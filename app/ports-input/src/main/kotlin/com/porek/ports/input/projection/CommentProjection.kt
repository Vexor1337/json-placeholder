package com.porek.ports.input.projection

data class CommentProjection(
    val postId: Int,
    val id : Int,
    val name: String,
    val email: String,
    val body: String
)
