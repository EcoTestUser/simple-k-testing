package ru.simple.testing.ui.pages

import com.codeborne.selenide.Selenide.`$`
import com.codeborne.selenide.SelenideElement
import ru.simple.testing.ui.pages.components.WithCards
import ru.simple.testing.ui.pages.components.WithShoppingCart

/** ??? */
object ProductsPage : AbstractPage(pageUrl = "/inventory.html"), WithShoppingCart, WithCards<InventoryCard>


/** ??? */
class InventoryCard(context: SelenideElement = `$`(".inventory_item")) : Card(context = context) {

    override val image by lazy { context.`$`(".inventory_item_img") }

    override val label by lazy { context.`$`(".inventory_item_label") }

    override val price by lazy { context.`$`(".inventory_item_price") }
}

/** ??? */
abstract class Card(val context: SelenideElement) : SelenideElement by context {

    abstract val image: SelenideElement

    abstract val label: SelenideElement

    abstract val price: SelenideElement

    open val addToCart: SelenideElement by lazy { context.`$`("button") }
}