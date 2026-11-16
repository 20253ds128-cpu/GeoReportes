package mx.edu.utez.georeportes.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import mx.edu.utez.georeportes.model.Reporte

@Composable
fun ListaScreen(
    reportes: List<Reporte>,
    onIrACrear: () -> Unit
) {
    Scaffold(
        floatingActionButton = {
            FloatingActionButton(onClick = onIrACrear) {
                Text("+")
            }
        }
    ) { padding ->
        Column(modifier = Modifier.padding(padding).padding(16.dp)) {
            Text("Lista de Reportes (${reportes.size})", style = MaterialTheme.typography.headlineSmall)
            // TODO (Rama de Integrante 2): Reemplazar esto por un LazyColumn con tarjetas bonitas
            reportes.forEach { reporte ->
                Text("- ${reporte.titulo}: ${reporte.descripcion}")
            }
        }
    }
}