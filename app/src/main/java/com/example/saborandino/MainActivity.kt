package com.example.saborandino


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.example.saborandino.navigation.SaborAndinoNavHost
import com.example.saborandino.ui.theme.SaborAndinoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Dentro de tu MainActivity.kt
        setContent {
            SaborAndinoTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    SaborAndinoNavHost() // Llamamos a nuestro NavHost principal
                }
            }
        }
    }
}