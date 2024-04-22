package com.porek.config

import com.porek.infrastructure.client.PlaceholderFeignClient
import feign.Feign
import feign.gson.GsonDecoder
import feign.gson.GsonEncoder
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class GitHubFeignClientConfig {
    @Bean
    fun createGitHubFeignClient(@Value("\${placeholder.api.url}") url: String): PlaceholderFeignClient {
        return Feign.builder()
            .decoder(GsonDecoder())
            .encoder(GsonEncoder())
            .target(PlaceholderFeignClient::class.java, url)
    }

}