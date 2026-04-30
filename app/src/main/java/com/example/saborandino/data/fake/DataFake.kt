package com.example.saborandino.data.fake

import com.example.saborandino.R
import com.example.saborandino.data.model.Plato

object FakePlatos {

    val lista = listOf(
        Plato(1, "Ceviche", "Pescado fresco", 25.0, "Entradas", R.drawable.ceviche),
        Plato(2, "Lomo Saltado", "Carne salteada", 30.0, "Fondo", R.drawable.lomo),
        Plato(3, "Arroz con Pollo", "Tradicional", 22.0, "Fondo", R.drawable.ic_launcher_foreground),
        Plato(4, "Chicha", "Bebida natural", 8.0, "Bebidas", R.drawable.chicha),
        Plato(5, "Tiramisú", "Postre", 15.0, "Postres", R.drawable.tiramisu),
        Plato(6, "Ensalada", "Fresca", 12.0, "Entradas", R.drawable.ensalada)
    )
}