@file:Suppress("unused")

package ru.simple.testing.ui.data

object UiUsers {

    val standardUser: UiUser by lazy { UiUser("standard_user", "secret_sauce") }
    val lockedOutUser: UiUser by lazy { UiUser("locked_out_user", "secret_sauce") }

}