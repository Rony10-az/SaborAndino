package com.example.saborandino.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.saborandino.data.fake.FakePlatos
import com.example.saborandino.navigation.Screen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MenuScreen(navController: NavHostController) {

    // 📌 Categoría seleccionada
    var categoriaSeleccionada by remember { mutableStateOf("Todos") }

    val categorias = listOf("Todos", "Entradas", "Fondo", "Postres", "Bebidas")

    // 📌 Filtrado de platos
    val platosFiltrados = if (categoriaSeleccionada == "Todos") {
        FakePlatos.lista
    } else {
        FakePlatos.lista.filter { it.categoria == categoriaSeleccionada }
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Menú") },
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
                .fillMaxSize()
        ) {

            // 🍱 FILTROS DE CATEGORÍAS
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                categorias.forEach { categoria ->

                    Button(
                        onClick = { categoriaSeleccionada = categoria },
                        colors = ButtonDefaults.buttonColors(
                            containerColor = if (categoriaSeleccionada == categoria)
                                MaterialTheme.colorScheme.primary
                            else
                                MaterialTheme.colorScheme.secondaryContainer
                        )
                    ) {
                        Text(categoria)
                    }
                }
            }

            Spacer(modifier = Modifier.height(8.dp))

            // 🍽 LISTA DE PLATOS
            LazyColumn(
                modifier = Modifier.fillMaxSize()
            ) {

                items(platosFiltrados) { plato ->

                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(8.dp)
                            .clickable {
                                navController.navigate(
                                    Screen.Detail.createRoute(plato.id)
                                )
                            }
                    ) {

                        Column(modifier = Modifier.padding(12.dp)) {

                            Text(
                                text = plato.nombre,
                                style = MaterialTheme.typography.titleMedium
                            )

                            Text(plato.descripcion)

                            Text("Categoría: ${plato.categoria}")

                            Text("S/ ${plato.precio}")
                        }
                    }
                }
            }
        }
    }
}