package com.example.saborandino.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.saborandino.screens.*
import com.example.saborandino.viewmodel.PedidoViewModel


@Composable
fun NavGraph(navController: NavHostController, viewModel: PedidoViewModel) {

    NavHost(navController = navController, startDestination = Screen.Login.route) {

        composable(Screen.Login.route) {
            LoginScreen(navController)
        }

        composable(Screen.Home.route) {
            HomeScreen(navController)
        }

        composable(Screen.Menu.route) {
            MenuScreen(navController)
        }

        composable(
            route = Screen.Detail.route,
            arguments = listOf(navArgument("id") { type = NavType.IntType })
        ) { backStack ->
            val id = backStack.arguments?.getInt("id") ?: 0
            DetailScreen(navController, id, viewModel)
        }

        composable(Screen.Order.route) {
            OrderScreen(navController, viewModel)
        }
    }
}