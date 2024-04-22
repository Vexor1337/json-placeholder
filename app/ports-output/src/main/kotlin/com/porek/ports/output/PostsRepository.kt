package com.porek.ports.output

import arrow.core.Either
import com.porek.app.commons.PlaceholderError
import com.porek.ports.output.persistance.PlaceholderPostDto
import org.springframework.stereotype.Repository

@Repository
interface PostsRepository {
    fun saveAllPosts(postsList: List<PlaceholderPostDto>) : Either<PlaceholderError, List<PlaceholderPostDto>>
}