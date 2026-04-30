package com.example.saborandino.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.saborandino.viewmodel.PedidoViewModel

/**
 * Pantalla: Perfil / Mi Pedido
 * - Datos del cliente
 * - Lista de platos agregados
 * - Cálculo de total
 */

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OrderScreen(
    navController: NavHostController,
    viewModel: PedidoViewModel
) {

    val items = viewModel.items
    val total = viewModel.total()

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Mi Pedido") },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(
                            imageVector = androidx.compose.material.icons.Icons.Default.ArrowBack,
                            contentDescription = "Atrás"
                        )
                    }
                }
            )
        }
    ) { padding ->

        Column(
            modifier = Modifier
                .padding(padding)
                .padding(16.dp)
                .fillMaxSize()
        ) {

            // 👤 DATOS DEL CLIENTE (simulado)
            Card(
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(modifier = Modifier.padding(12.dp)) {

                    Text(
                        text = "Datos del Cliente",
                        style = MaterialTheme.typography.titleMedium
                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    Text("Nombre: Juan Pérez")
                    Text("Correo: juan@gmail.com")
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            // 🍽 LISTA DE PLATOS
            Text(
                text = "Platos del Pedido",
                style = MaterialTheme.typography.titleMedium
            )

            Spacer(modifier = Modifier.height(8.dp))

            LazyColumn(
                modifier = Modifier.weight(1f)
            ) {
                items(items) { item ->

                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 6.dp)
                    ) {
                        Column(modifier = Modifier.padding(12.dp)) {

                            Text(item.plato.nombre)
                            Text("Cantidad: ${item.cantidad}")
                            Text("Precio: S/ ${item.plato.precio}")
                            Text(
                                "Subtotal: S/ ${
                                    item.plato.precio * item.cantidad
                                }"
                            )
                        }
                    }
                }
            }

            Spacer(modifier = Modifier.height(10.dp))

            Divider()

            Spacer(modifier = Modifier.height(10.dp))

            // 💰 TOTAL
            Text(
                text = "TOTAL: S/ ${"%.2f".format(total)}",
                style = MaterialTheme.typography.titleLarge
            )

            Spacer(modifier = Modifier.height(10.dp))

            Button(
                onClick = { navController.navigate("home") },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Volver al Home")
            }
        }
    }
}