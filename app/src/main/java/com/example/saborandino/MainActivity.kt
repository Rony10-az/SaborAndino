package com.example.saborandino


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.rememberNavController
import com.example.saborandino.navigation.NavGraph
import com.example.saborandino.viewmodel.PedidoViewModel
import com.example.saborandino.ui.theme.SaborAndinoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SaborAndinoTheme {

                val navController = rememberNavController()
                val viewModel: PedidoViewModel = viewModel()

                NavGraph(navController, viewModel)
            }
        }
    }
}