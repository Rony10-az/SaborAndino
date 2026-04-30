package com.example.saborandino.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

@Composable
fun LoginScreen(navController: NavHostController) {

    var correo by remember { mutableStateOf("") }
    var pass by remember { mutableStateOf("") }

    var errorCorreo by remember { mutableStateOf("") }
    var errorPass by remember { mutableStateOf("") }

    fun validar(): Boolean {

        var valido = true

        // 📧 validación correo
        if (correo.isBlank()) {
            errorCorreo = "El correo es obligatorio"
            valido = false
        } else if (!android.util.Patterns.EMAIL_ADDRESS.matcher(correo).matches()) {
            errorCorreo = "Correo inválido"
            valido = false
        } else {
            errorCorreo = ""
        }

        // 🔑 validación password
        if (pass.isBlank()) {
            errorPass = "La contraseña es obligatoria"
            valido = false
        } else if (pass.length < 6) {
            errorPass = "Mínimo 6 caracteres"
            valido = false
        } else {
            errorPass = ""
        }

        return valido
    }

    Column(Modifier.padding(16.dp)) {

        Text("Login", style = MaterialTheme.typography.titleLarge)

        Spacer(modifier = Modifier.height(12.dp))

        // 📧 CORREO
        OutlinedTextField(
            value = correo,
            onValueChange = { correo = it },
            label = { Text("Correo") },
            isError = errorCorreo.isNotEmpty(),
            modifier = Modifier.fillMaxWidth()
        )

        if (errorCorreo.isNotEmpty()) {
            Text(
                text = errorCorreo,
                color = MaterialTheme.colorScheme.error
            )
        }

        Spacer(modifier = Modifier.height(8.dp))

        // 🔑 PASSWORD
        OutlinedTextField(
            value = pass,
            onValueChange = { pass = it },
            label = { Text("Contraseña") },
            visualTransformation = PasswordVisualTransformation(),
            isError = errorPass.isNotEmpty(),
            modifier = Modifier.fillMaxWidth()
        )

        if (errorPass.isNotEmpty()) {
            Text(
                text = errorPass,
                color = MaterialTheme.colorScheme.error
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        // 🔘 BOTÓN
        Button(
            onClick = {
                if (validar()) {
                    navController.navigate("home")
                }
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Ingresar")
        }
    }
}