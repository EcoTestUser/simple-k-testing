package ru.simple.testing.ui.pages.components

import com.codeborne.selenide.Selenide
import com.codeborne.selenide.SelenideElement

/** ??? */
interface WithShoppingCart {

    val shoppingCart: SelenideElement
        get() = Selenide.element("[id='shopping_cart_container']")
}