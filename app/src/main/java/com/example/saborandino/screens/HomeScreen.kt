package com.example.saborandino.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

@Composable
fun HomeScreen(navController: NavHostController) {

    Column(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxSize()
    ) {

        // 👋 SALUDO
        Text(
            text = " Bienvenido a Sabor Andino",
            style = MaterialTheme.typography.headlineMedium
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = "Explora nuestro menú y realiza tu pedido",
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )

        Spacer(modifier = Modifier.height(24.dp))

        // 📦 TARJETA MENÚ
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 12.dp)
        ) {
            Column(
                modifier = Modifier.padding(16.dp)
            ) {

                Text(
                    text = "🍽 Ver Menú",
                    style = MaterialTheme.typography.titleMedium
                )

                Spacer(modifier = Modifier.height(6.dp))

                Text("Explora nuestros platos disponibles")

                Spacer(modifier = Modifier.height(10.dp))

                Button(
                    onClick = { navController.navigate("menu") },
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text("Ir al Menú")
                }
            }
        }

        // 🛒 TARJETA PEDIDO
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 12.dp)
        ) {
            Column(
                modifier = Modifier.padding(16.dp)
            ) {

                Text(
                    text = "🛒 Mi Pedido",
                    style = MaterialTheme.typography.titleMedium
                )

                Spacer(modifier = Modifier.height(6.dp))

                Text("Revisa los platos agregados y el total")

                Spacer(modifier = Modifier.height(10.dp))

                Button(
                    onClick = { navController.navigate("order") },
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text("Ver Pedido")
                }
            }
        }
    }
}