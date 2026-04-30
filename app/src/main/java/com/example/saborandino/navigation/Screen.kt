
package com.example.saborandino.navigation

sealed class Screen(val route: String) {

    object Login : Screen("login")

    object Home : Screen("home")

    object Menu : Screen("menu")

    object Detail : Screen("detail/{id}") {
        fun createRoute(id: Int): String = "detail/$id"
    }

    object Order : Screen("order")
}