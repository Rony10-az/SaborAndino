package com.example.saborandino.data

import com.example.saborandino.R
import com.example.saborandino.model.Plato

// Esta lista simula lo que en el futuro vendría de una base de datos o API.
val menuSaborAndino = listOf(
    Plato(1, "Ceviche Clásico", "Pescado fresco marinado en limón.", "Delicioso pescado fresco del día con ají limo, cebolla roja y camote.", 35.0, "Entradas", R.drawable.ceviche),
    Plato(2, "Lomo Saltado", "Trozos de carne con cebolla y tomate.", "Jugoso lomo de res salteado al wok con salsa de soya, acompañado de papas fritas y arroz.", 40.0, "Platos de Fondo", R.drawable.lomo),
    Plato(3, "Ají de Gallina", "Crema de ají amarillo con pollo.", "Tradicional receta casera a base de ají amarillo, pan, leche y pollo deshilachado.", 30.0, "Platos de Fondo", R.drawable.aji),
    Plato(4, "Suspiro a la Limeña", "Dulce de leche con merengue.", "El postre limeño por excelencia, suave manjar de yemas coronado con merengue al oporto.", 15.0, "Postres", R.drawable.suspiro),
    Plato(5, "Chicha Morada", "Bebida refrescante de maíz morado.", "Preparada tradicionalmente con maíz morado, manzanas, piña, canela y clavo de olor.", 10.0, "Bebidas", R.drawable.chicha),
    Plato(6, "Pisco Sour", "Cóctel bandera peruano.", "Nuestra receta secreta con Pisco Quebranta, zumo de limón, jarabe de goma y clara de huevo.", 25.0, "Bebidas", R.drawable.piscosour))
