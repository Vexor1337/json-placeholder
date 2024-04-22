package com.porek.ports.output.persistance

data class PlaceholderPostDto(
    val userId: Int,
    val id: Int,
    val title: String,
    val body: String
)