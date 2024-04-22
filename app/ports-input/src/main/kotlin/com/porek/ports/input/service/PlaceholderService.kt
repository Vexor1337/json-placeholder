package com.porek.ports.input.service

import arrow.core.Either
import com.porek.app.commons.PlaceholderError
import com.porek.ports.input.projection.PlaceholderPostProjection
import org.springframework.stereotype.Service

@Service
interface PlaceholderService {
    fun getAllServicesAndSave(): Either<PlaceholderError, List<PlaceholderPostProjection>>
}