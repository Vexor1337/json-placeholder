package com.porek.ports.output.persistance

data class CommentDto(
    val postId: Int,
    val id : Int,
    val name: String,
    val email: String,
    val body: String
)
