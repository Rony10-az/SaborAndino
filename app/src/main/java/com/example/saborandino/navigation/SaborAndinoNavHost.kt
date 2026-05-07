package com.example.saborandino.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.saborandino.screens.login.LoginScreen
import com.example.saborandino.screens.home.HomeScreen
import com.example.saborandino.screens.menu.MenuScreen


@Composable
fun SaborAndinoNavHost() {
    // Esto recuerda el estado de la navegación entre recomposiciones.
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Ruta.Login.ruta) {

        composable(Ruta.Login.ruta) {
            LoginScreen(
                onLoginSuccess = {
                    // Cuando el login es exitoso, vamos al Home
                    navController.navigate(Ruta.Home.ruta) {
                        // Opcional: Borramos el Login del historial para que el botón "atrás" del celular no vuelva aquí
                        popUpTo(Ruta.Login.ruta) { inclusive = true }
                    }
                }
            )
        }

        // --- PANTALLAS PENDIENTES DE CREAR ---
        composable(Ruta.Home.ruta) {
            HomeScreen(
                onNavigateToMenu = { navController.navigate(Ruta.Menu.ruta) },
                onNavigateToPerfil = { navController.navigate(Ruta.Perfil.ruta) }
            )
        }

        composable(Ruta.Menu.ruta) {
            MenuScreen(
                onPlatoSeleccionado = { idPlato ->
                    // Navegamos pasando el ID que nos devolvió el PlatoCardComponent
                    navController.navigate(Ruta.Detalle.crearRuta(idPlato))
                },
                onBack = {
                    navController.popBackStack() // Saca la pantalla actual y vuelve a la anterior (Home)
                }
            )
        }

        composable(
            route = Ruta.Detalle.ruta,
            arguments = listOf(navArgument("platoId") { type = NavType.IntType })
        ) { backStackEntry ->
            val platoId = backStackEntry.arguments?.getInt("platoId") ?: return@composable
            // Aquí irá DetallePlatoScreen(platoId = platoId)
        }

        composable(Ruta.Perfil.ruta) {
            // Aquí irá PerfilScreen
        }
    }
}