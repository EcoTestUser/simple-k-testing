package ru.simple.testing.ui.pages.components

import com.codeborne.selenide.Selenide.`$$`
import ru.simple.testing.ui.pages.Card
import kotlin.reflect.full.createInstance
import kotlin.reflect.full.primaryConstructor

/** ??? */
interface WithCards<T>

/** ??? */
inline val <reified T : Card> WithCards<T>.cards: List<T>
    get() {
        return `$$`(T::class.createInstance().context.searchCriteria).map {
            T::class.primaryConstructor!!.call(it)
        }
    }