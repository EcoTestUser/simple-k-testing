package ru.simple.testing.be.dto

data class PostDto(
    override var id: Int? = null,
    var userId: Int,
    var title: String,
    var body: String? = null
) : Identifiable