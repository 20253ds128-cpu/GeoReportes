package mx.edu.utez.georeportes.ui.viewmodel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import mx.edu.utez.georeportes.model.Reporte

class ReporteViewModel : ViewModel() {
    // Lista temporal de prueba para que el integrante 2 pueda diseñar la UI desde el minuto 1
    private val _reportes = MutableStateFlow(
        listOf(
            Reporte("1", "Ejemplo 1", "Bache de la avenida", 18.931, -99.234),
            Reporte("2", "Ejemplo 2", "Luminaria apagada", 18.925, -99.230)
        )
    )

    val reportes: StateFlow<List<Reporte>> = _reportes.asStateFlow()
}