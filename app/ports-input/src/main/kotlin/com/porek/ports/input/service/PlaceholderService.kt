package com.porek.ports.input.service

import arrow.core.Either
import com.porek.app.commons.PlaceholderError
import com.porek.app.commons.web.ResponseWrapper
import com.porek.ports.input.projection.CommentProjection
import com.porek.ports.input.projection.PlaceholderPostProjection
import org.springframework.stereotype.Service

@Service
interface PlaceholderService {
    fun getAllServicesAndSave(): Either<PlaceholderError, List<PlaceholderPostProjection>>
    fun getCommentsGroupedByDomainFromPosts(numberOfPosts: Int): Either<PlaceholderError, List<CommentProjection>>
}