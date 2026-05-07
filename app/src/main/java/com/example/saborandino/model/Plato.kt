package com.example.saborandino.model

// Usamos 'data class' porque su único propósito es almacenar información.
data class Plato(
    val id: Int,
    val nombre: String,
    val descripcionCorta: String,
    val descripcionCompleta: String,
    val precio: Double,
    val categoria: String,
    val imagenResId: Int // <- NUEVO CAMPO PARA LA IMAGEN
)