package com.example.saborandino.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.saborandino.data.fake.FakePlatos
import com.example.saborandino.viewmodel.PedidoViewModel

@Composable
fun DetailScreen(
    navController: NavHostController,
    id: Int,
    viewModel: PedidoViewModel
) {

    val plato = FakePlatos.lista.find { it.id == id }!!

    var cantidad by remember { mutableStateOf(1) }

    Column(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxSize()
    ) {

        // 🖼 IMAGEN DEL PLATO
        Image(
            painter = painterResource(id = plato.imagen),
            contentDescription = plato.nombre,
            modifier = Modifier
                .fillMaxWidth()
                .height(220.dp)
        )

        Spacer(modifier = Modifier.height(12.dp))

        // 📌 INFO DEL PLATO
        Text(plato.nombre, style = MaterialTheme.typography.titleLarge)
        Text(plato.descripcion)
        Text("S/ ${plato.precio}")

        Spacer(modifier = Modifier.height(12.dp))

        // ➖➕ CANTIDAD
        Row {

            Button(onClick = { if (cantidad > 1) cantidad-- }) {
                Text("-")
            }

            Text(
                text = "$cantidad",
                modifier = Modifier.padding(16.dp)
            )

            Button(onClick = { cantidad++ }) {
                Text("+")
            }
        }

        Spacer(modifier = Modifier.height(12.dp))

        // 🛒 BOTÓN AGREGAR
        Button(
            onClick = {
                viewModel.agregar(plato, cantidad)
                navController.navigate("order")
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Agregar al pedido")
        }
    }
}