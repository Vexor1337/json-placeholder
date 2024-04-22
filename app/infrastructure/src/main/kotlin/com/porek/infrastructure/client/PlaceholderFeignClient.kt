package com.porek.infrastructure.client

import com.porek.ports.output.persistance.PlaceholderPostDto
import feign.RequestLine

interface PlaceholderFeignClient {
    @RequestLine("GET posts")
    fun getAllPosts(): List<PlaceholderPostDto>
}