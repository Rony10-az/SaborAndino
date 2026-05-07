package com.example.saborandino.screens.menu

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.saborandino.data.menuSaborAndino

// OptIn es necesario en algunas versiones de Compose para usar TopAppBar
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MenuScreen(
    onPlatoSeleccionado: (Int) -> Unit,
    onBack: () -> Unit
) {
    // 1. Estado para el filtro (por defecto muestra "Todos")
    var categoriaSeleccionada by remember { mutableStateOf("Todos") }
    val categorias = listOf("Todos", "Entradas", "Platos de Fondo", "Postres", "Bebidas")

    // 2. Lógica de filtrado reactivo
    val platosMostrados = if (categoriaSeleccionada == "Todos") {
        menuSaborAndino
    } else {
        menuSaborAndino.filter { it.categoria == categoriaSeleccionada }
    }

    // Scaffold para colocar la TopAppBar fácilmente
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Menú de Sabor Andino") },
                navigationIcon = {
                    IconButton(onClick = onBack) {
                        Icon(
                            imageVector = Icons.Default.ArrowBack, // La flecha que pide la rúbrica
                            contentDescription = "Volver atrás"
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.onPrimaryContainer
                )
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            // 3. Fila de Filtros (LazyRow para hacer scroll horizontal si hay muchas categorías)
            LazyRow(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp, vertical = 8.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                items(categorias) { categoria ->
                    FilterChip(
                        selected = categoriaSeleccionada == categoria,
                        onClick = { categoriaSeleccionada = categoria },
                        label = { Text(categoria) }
                    )
                }
            }

            // 4. Lista de Platos (LazyColumn)
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 16.dp),
                contentPadding = PaddingValues(bottom = 16.dp) // Espacio extra al final del scroll
            ) {
                items(platosMostrados) { plato ->
                    PlatoCardComponent(
                        plato = plato,
                        onClick = onPlatoSeleccionado
                    )
                }
            }
        }
    }
}