package ru.simple.testing.ui.pages

import com.codeborne.selenide.Selenide
import com.codeborne.selenide.SelenideElement

interface WithShoppingCard {
    val shoppingCart: SelenideElement
        get() = Selenide.element("[id='shopping_cart_container']")
}