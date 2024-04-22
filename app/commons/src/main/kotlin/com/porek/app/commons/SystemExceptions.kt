package com.porek.app.commons

sealed interface PlaceholderError : EitherError


class PlaceholderUnauthorizedException(): PlaceholderError {
    override val message: String
        get() = "Unable to authorize at api"
}
class PageNotFoundError(): PlaceholderError {
    override val message: String
        get() = "Page not found"
}

class PlaceholderGenericException(override val message: String): PlaceholderError
class PostRepoGenericError(override val message: String): PlaceholderError