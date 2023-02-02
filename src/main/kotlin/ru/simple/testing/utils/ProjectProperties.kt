package ru.simple.testing.utils

data class ProjectProperties(val uiBaseUrl: String)

val projectProperties: ProjectProperties by lazy { ProjectProperties(uiBaseUrl = "https://www.saucedemo.com") }