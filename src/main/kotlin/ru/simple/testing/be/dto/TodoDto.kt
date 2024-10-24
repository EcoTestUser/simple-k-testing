package ru.simple.testing.be.dto

data class TodoDto(
    override var id: Int? = null,
    var userId: Int?,
    var title: String? = null,
    var completed: Boolean?,
) : Identifiable