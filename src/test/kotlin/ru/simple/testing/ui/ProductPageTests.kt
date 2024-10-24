package ru.simple.testing.ui

import com.codeborne.selenide.Condition.*
import com.codeborne.selenide.logevents.SelenideLogger
import io.qameta.allure.selenide.AllureSelenide
import org.hamcrest.CoreMatchers.equalTo
import org.hamcrest.MatcherAssert.assertThat
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import ru.simple.testing.ui.data.UiUser
import ru.simple.testing.ui.data.UiUsers
import ru.simple.testing.ui.pages.ProductsPage
import ru.simple.testing.ui.pages.components.cards
import ru.simple.testing.ui.pages.openBy


class ProductPageTests {

    companion object {
        @JvmStatic
        @BeforeAll
        fun setupAllureReports() {
            SelenideLogger.addListener("AllureSelenide", AllureSelenide())
        }
    }

    @Test
    fun productsOpenedTest() {
        val user = UiUsers.standardUser
        with(ProductsPage.openBy(user)) {
            checkIsOpened()
            shoppingCart.should(visible)
        }
    }

    @ParameterizedTest
    @MethodSource("ru.simple.testing.ui.data.UiUsers#standardUser")
    fun productsCardsTest(user: UiUser) {
        with(ProductsPage.openBy(user)) {
            checkIsOpened()

            assertThat(cards.size, equalTo(6))

            val expCardData = object {
                val labelText = "Sauce Labs Bolt T-Shirt"
                val price = "15.99"
            }

            cards.find { it.label.text.contains(expCardData.labelText) }
                ?.let { card ->
                    card.label.should(text(expCardData.labelText))
                    card.price.should(text(expCardData.price))
                    card.addToCart.should(enabled)
                } ?: throw AssertionError("Card with label '${expCardData.labelText}' not found")
        }
    }

    @ParameterizedTest
    @MethodSource("ru.simple.testing.ui.data.UiUsers#standardUser")
    fun productsAddToCartTest(user: UiUser) {
        //TODO
    }

}