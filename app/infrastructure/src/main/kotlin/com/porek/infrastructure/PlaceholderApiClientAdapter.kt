package com.porek.infrastructure

import arrow.core.Either
import com.porek.app.commons.PageNotFoundError
import com.porek.app.commons.PlaceholderError
import com.porek.app.commons.PlaceholderGenericException
import com.porek.app.commons.PlaceholderUnauthorizedException
import com.porek.infrastructure.client.PlaceholderFeignClient
import com.porek.ports.output.PlaceholderApiClient
import com.porek.ports.output.persistance.PlaceholderPostDto
import feign.FeignException
import org.springframework.stereotype.Repository

@Repository
class PlaceholderApiClientAdapter(private val placeholderFeignClient: PlaceholderFeignClient) : PlaceholderApiClient {
    override fun getAllPosts(): Either<PlaceholderError, List<PlaceholderPostDto>> =
        Either.catch {
            placeholderFeignClient.getAllPosts()
        }.mapLeft { e ->
            when (e) {
                is FeignException.Unauthorized -> PlaceholderUnauthorizedException()
                is FeignException.NotFound -> PageNotFoundError()
                else -> PlaceholderGenericException(e.message!!)
            }
        }
}
