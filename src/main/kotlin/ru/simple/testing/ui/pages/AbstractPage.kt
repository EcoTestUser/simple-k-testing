package ru.simple.testing.ui.pages

import com.codeborne.selenide.Configuration
import com.codeborne.selenide.Selenide
import com.codeborne.selenide.Selenide.webdriver
import com.codeborne.selenide.WebDriverConditions.url
import com.codeborne.selenide.WebDriverRunner
import io.qameta.allure.Step
import org.openqa.selenium.Cookie
import ru.simple.testing.ui.data.UiUser
import ru.simple.testing.utils.projectProperties
import ru.simple.testing.utils.step


/** ??? */
abstract class AbstractPage(val pageUrl: String) {

    @Step("Проверяем, что страница '{this.pageUrl}' открыта")
    open fun checkIsOpened() {
        webdriver().shouldHave(url(projectProperties.uiBaseUrl + pageUrl))
    }
}

/** ??? */
fun <T : AbstractPage> T.openBy(user: UiUser): T {
    Configuration.browserVersion = "128.0"
    val url = projectProperties.uiBaseUrl + pageUrl
    return step("Открываем страницу '$url' под пользователем '${user.login}'") {
        Selenide.open(url)
        WebDriverRunner.getWebDriver().manage().addCookie(Cookie("session-username", user.login))
        Selenide.open(url)
        this
    }
}

/** ??? */
fun <T : AbstractPage> T.open(): T {
    val url = projectProperties.uiBaseUrl + pageUrl
    return this.also { step("Открываем страницу '$url'") { Selenide.open(url) } }
}