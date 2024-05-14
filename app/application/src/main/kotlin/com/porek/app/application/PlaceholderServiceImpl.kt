package com.porek.app.application

import arrow.core.Either
import arrow.core.computations.either.eager
import arrow.core.flatMap
import arrow.core.left
import arrow.core.raise.either
import arrow.core.right
import com.porek.app.commons.PlaceholderError
import com.porek.ports.input.projection.CommentProjection
import com.porek.ports.input.projection.PlaceholderPostProjection
import com.porek.ports.input.service.PlaceholderService
import com.porek.ports.output.PlaceholderApiClient
import com.porek.ports.output.PostsRepository
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service

@Service
class PlaceholderServiceImpl(
    private val placeholderApiClient: PlaceholderApiClient,
    private val postsRepository: PostsRepository
) : PlaceholderService {
    override fun getAllServicesAndSave(): Either<PlaceholderError, List<PlaceholderPostProjection>> =
        placeholderApiClient.getAllPosts().fold(
            { it.left() },
            {
                postsRepository.saveAllPosts(it).flatMap { it.map { it.toProjection() }.right() }
            }
        )

    override fun getCommentsGroupedByDomainFromPosts(numberOfPosts: Int): Either<PlaceholderError, List<CommentProjection>> = eager {
            val posts  = placeholderApiClient.getAllPosts().bind()
            val comments = posts.flatMap { placeholderApiClient.getCommentsByPostId(it.id).bind() }



            //fold(
            { it.left() },
            {
                val posts = it.take(numberOfPosts)
                    posts.forEach {
                    placeholderApiClient.getCommentsByPostId(it.id).fold(
                        {it.message.left()},
                        {it.}
                    )
                }
            }
        )
    }
}