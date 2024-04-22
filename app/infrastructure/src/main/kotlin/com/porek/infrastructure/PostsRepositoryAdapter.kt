package com.porek.infrastructure

import arrow.core.Either
import com.fasterxml.jackson.databind.ObjectMapper
import com.porek.app.commons.PlaceholderError
import com.porek.app.commons.PostRepoGenericError
import com.porek.ports.output.PostsRepository
import com.porek.ports.output.persistance.PlaceholderPostDto
import org.springframework.stereotype.Repository
import java.io.File

@Repository
class PostsRepositoryAdapter : PostsRepository {
    override fun saveAllPosts(postsList: List<PlaceholderPostDto>): Either<PlaceholderError, List<PlaceholderPostDto>> {
        val mapper = ObjectMapper()
         return Either.catch {
            postsList.forEach {post ->
                val fileName = "${post.id}.json"
                File(fileName).writeText(mapper.writeValueAsString(postsList))
            }
             postsList
        }.mapLeft { PostRepoGenericError(it.message!!) }
    }
}