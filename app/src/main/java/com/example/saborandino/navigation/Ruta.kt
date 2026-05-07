package com.example.saborandino.navigation

// 'sealed class' restringe qué clases pueden heredar de ella.
// Es perfecto para tener un número cerrado de pantallas.
sealed class Ruta(val ruta: String) {
    object Login : Ruta("login")
    object Home : Ruta("home")
    object Menu : Ruta("menu")
    object Perfil : Ruta("perfil")

    // Esta ruta necesita recibir un ID numérico para saber qué plato mostrar.
    object Detalle : Ruta("detalle/{platoId}") {
        fun crearRuta(platoId: Int) = "detalle/$platoId"
    }
}