package ru.simple.testing.ui

import com.codeborne.selenide.Condition.value
import com.codeborne.selenide.logevents.SelenideLogger
import io.qameta.allure.selenide.AllureSelenide
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import ru.simple.testing.ui.data.UiUsers
import ru.simple.testing.ui.pages.LoginPage
import ru.simple.testing.ui.pages.ProductsPage
import ru.simple.testing.ui.pages.open


class LoginPageTests {

    companion object {
        @JvmStatic
        @BeforeAll
        fun setupAllureReports() {
            SelenideLogger.addListener("AllureSelenide", AllureSelenide())
        }
    }

    @Test
    fun loginSuccessTest() {
        val user = UiUsers.standardUser
        with(LoginPage.open()) {
            userName.value = user.login
            password.value = user.password
            userName.should(value(user.login))
            password.should(value(user.password))
            loginBtn.click()
        }
        ProductsPage.checkIsOpened()
    }
}