package ru.simple.testing.utils

import io.qameta.allure.Step

@Suppress("UNUSED_PARAMETER")
@Step("{stepName}")
fun <T> step(stepName: String, body: () -> T): T = body()