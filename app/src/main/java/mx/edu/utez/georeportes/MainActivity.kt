package mx.edu.utez.georeportes

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import mx.edu.utez.georeportes.ui.screens.CrearScreen
import mx.edu.utez.georeportes.ui.screens.ListaScreen
import mx.edu.utez.georeportes.ui.viewmodel.ReporteViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MaterialTheme {
                val navController = rememberNavController()
                val viewModel: ReporteViewModel = viewModel()
                val reportes by viewModel.reportes.collectAsState()

                NavHost(navController = navController, startDestination = "lista") {
                    composable("lista") {
                        ListaScreen(
                            reportes = reportes,
                            onIrACrear = { navController.navigate("crear") }
                        )
                    }
                    composable("crear") {
                        CrearScreen(
                            onVolver = { navController.popBackStack() }
                        )
                    }
                }
            }
        }
    }
}