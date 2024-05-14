package com.porek.ports.output

import arrow.core.Either
import com.porek.app.commons.PlaceholderError
import com.porek.ports.output.persistance.CommentDto
import com.porek.ports.output.persistance.PlaceholderPostDto
import org.springframework.stereotype.Repository

@Repository
interface PlaceholderApiClient {
    fun getAllPosts(): Either<PlaceholderError, List<PlaceholderPostDto>>
    fun getCommentsByPostId(postId: Int): Either<PlaceholderError, List<CommentDto>>
}