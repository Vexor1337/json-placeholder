package com.porek.app.application

import arrow.core.Either
import arrow.core.flatMap
import arrow.core.left
import arrow.core.right
import com.porek.app.commons.PlaceholderError
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
                postsRepository.saveAllPosts(it).flatMap { it.map { it.toProjection() }.right()  }
            }
        )
}