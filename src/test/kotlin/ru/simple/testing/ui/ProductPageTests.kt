package ru.simple.testing.ui

import com.codeborne.selenide.Condition.visible
import com.codeborne.selenide.logevents.SelenideLogger
import io.qameta.allure.selenide.AllureSelenide
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import ru.simple.testing.ui.data.UiUsers
import ru.simple.testing.ui.pages.ProductsPage
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
    fun productsOpenedSuccessTest() {
        val user = UiUsers.standardUser
        with(ProductsPage.openBy(user)) {
            checkIsOpened()
            shoppingCart.should(visible)
        }
    }
}