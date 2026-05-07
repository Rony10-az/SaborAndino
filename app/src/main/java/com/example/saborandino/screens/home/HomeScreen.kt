package com.example.saborandino.screens.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.saborandino.R // Ajusta al paquete de tu app

@Composable
fun HomeScreen(
    onNavigateToMenu: () -> Unit,
    onNavigateToPerfil: () -> Unit
    // Podrías añadir onNavigateToPedido si tienes una ruta separada
) {
    // Scaffold nos da la estructura base de Material Design
    Scaffold { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // 1. Saludo personalizado (puedes recibir el nombre como parámetro luego)
            Text(
                text = "¡Hola, Cliente!",
                fontSize = 28.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(bottom = 8.dp)
            )
            Text(
                text = "¿Qué se te antoja hoy en Sabor Andino?",
                fontSize = 16.sp,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                modifier = Modifier.padding(bottom = 24.dp)
            )

            // 2. Imagen destacada (Promoción o Banner)
            // Aquí usamos painterResource para cargar una imagen local
            Image(
                painter = painterResource(id = R.drawable.banner), // Cambia por tu imagen de banner
                contentDescription = "Banner Promocional",
                contentScale = ContentScale.Crop, // Recorta la imagen para que llene el espacio
                modifier = Modifier
                    .fillMaxWidth()
                    .height(150.dp)
                    .clip(RoundedCornerShape(16.dp)) // Le da bordes redondeados
                    .padding(bottom = 24.dp)
            )

            // 3. Tarjetas de acceso rápido
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                // Tarjeta Menú
                BotonAccesoRapido(
                    titulo = "Ver Menú",
                    iconoResId = android.R.drawable.ic_menu_agenda, // Icono por defecto de Android
                    onClick = onNavigateToMenu
                )

                // Tarjeta Mi Perfil / Pedido
                BotonAccesoRapido(
                    titulo = "Mi Perfil",
                    iconoResId = android.R.drawable.ic_menu_myplaces,
                    onClick = onNavigateToPerfil
                )
            }
        }
    }
}

// Sub-componente para hacer tarjetas bonitas y no repetir código
@Composable
fun BotonAccesoRapido(
    titulo: String,
    iconoResId: Int,
    onClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .size(120.dp)
            .clickable { onClick() },
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.primaryContainer)
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Icon(
                painter = painterResource(id = iconoResId),
                contentDescription = titulo,
                modifier = Modifier.size(48.dp),
                tint = MaterialTheme.colorScheme.onPrimaryContainer
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = titulo, fontWeight = FontWeight.Medium)
        }
    }
}