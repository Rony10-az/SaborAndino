package com.example.saborandino.screens.login

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun LoginScreen(onLoginSuccess: () -> Unit) {
    // Usamos 'remember' y 'mutableStateOf' para que Compose "recuerde"
    // lo que el usuario escribe cada vez que la pantalla se redibuja.
    var correo by remember { mutableStateOf("") }
    var contrasena by remember { mutableStateOf("") }
    var mensajeError by remember { mutableStateOf("") }

    // Column agrupa los elementos verticalmente
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "Bienvenido a Sabor Andino", fontSize = 24.sp)

        Spacer(modifier = Modifier.height(32.dp))

        // Campo para el correo
        OutlinedTextField(
            value = correo,
            onValueChange = { correo = it }, // Actualiza la variable 'correo'
            label = { Text("Correo electrónico") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Campo para la contraseña
        OutlinedTextField(
            value = contrasena,
            onValueChange = { contrasena = it },
            label = { Text("Contraseña") },
            visualTransformation = PasswordVisualTransformation(), // Oculta el texto con asteriscos
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(8.dp))

        // Mostrar mensaje de error si existe
        if (mensajeError.isNotEmpty()) {
            Text(text = mensajeError, color = MaterialTheme.colorScheme.error)
        }

        Spacer(modifier = Modifier.height(24.dp))

        // Botón de ingreso con validación básica
        Button(
            onClick = {
                // VALIDACIÓN BÁSICA: Que no estén vacíos
                if (correo.isNotBlank() && contrasena.isNotBlank()) {
                    mensajeError = ""
                    onLoginSuccess() // Ejecuta la navegación hacia el Home
                } else {
                    mensajeError = "Por favor, completa todos los campos."
                }
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Ingresar")
        }
    }
}