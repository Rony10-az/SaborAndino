package com.example.saborandino.screens.detalle

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.saborandino.data.menuSaborAndino

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetallePlatoScreen(
    platoId: Int, // Recibimos el ID desde la navegación
    onBack: () -> Unit,
    onAgregarPedido: (Int, Int) -> Unit // Pasaremos el ID del plato y la cantidad
) {
    // 1. Buscamos el plato en nuestra base de datos falsa
    val plato = menuSaborAndino.find { it.id == platoId }

    // 2. Estado para el selector de cantidad
    var cantidad by remember { mutableStateOf(1) }

    // Si por algún error no encuentra el plato, mostramos un mensaje
    if (plato == null) {
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            Text("Error: Plato no encontrado")
        }
        return
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(plato.nombre) },
                navigationIcon = {
                    IconButton(onClick = onBack) {
                        Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "Volver")
                    }
                }
            )
        }
    ) { paddingValues ->
        // Usamos verticalScroll por si la descripción es muy larga
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(16.dp)
                .verticalScroll(rememberScrollState())
        ) {
            // Imagen grande
            Image(
                painter = painterResource(id = plato.imagenResId),
                contentDescription = plato.nombre,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(250.dp)
                    .clip(RoundedCornerShape(16.dp))
            )

            Spacer(modifier = Modifier.height(24.dp))

            // Título y Precio
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = plato.nombre,
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.weight(1f) // Para que no empuje el precio fuera de la pantalla
                )
                Text(
                    text = "S/ ${plato.precio}",
                    fontSize = 22.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = MaterialTheme.colorScheme.primary
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Descripción Completa
            Text(
                text = "Descripción",
                fontSize = 18.sp,
                fontWeight = FontWeight.Medium
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = plato.descripcionCompleta,
                fontSize = 16.sp,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )

            Spacer(modifier = Modifier.height(32.dp))

            // Selector de Cantidad
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                // Botón Menos
                FilledTonalIconButton(
                    onClick = { if (cantidad > 1) cantidad-- }
                ) {
                    Text("-", fontSize = 20.sp, fontWeight = FontWeight.Bold)
                }

                Text(
                    text = cantidad.toString(),
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(horizontal = 24.dp)
                )

                // Botón Más
                FilledTonalIconButton(
                    onClick = { cantidad++ }
                ) {
                    Text("+", fontSize = 20.sp, fontWeight = FontWeight.Bold)
                }
            }

            Spacer(modifier = Modifier.height(24.dp))

            // Botón Agregar al Pedido (calcula el total dinámicamente)
            Button(
                onClick = { onAgregarPedido(plato.id, cantidad) },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)
            ) {
                Text(
                    text = "Agregar al pedido (S/ ${plato.precio * cantidad})",
                    fontSize = 16.sp
                )
            }
        }
    }
}