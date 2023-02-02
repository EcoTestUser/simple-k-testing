package ru.simple.testing.ui.pages

import com.codeborne.selenide.Selenide.element

object LoginPage : AbstractPage(pageUrl = "/") {

    val userName by lazy { element("[id='user-name']") }
    val password by lazy { element("[id='password']") }
    val loginBtn by lazy { element("[id='login-button']") }
}