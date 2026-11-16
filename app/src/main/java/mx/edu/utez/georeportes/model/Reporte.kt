package mx.edu.utez.georeportes.model

data class Reporte(
    val id: String = "",
    val titulo: String = "",
    val descripcion: String = "",
    val latitud: Double = 0.0,
    val longitud: Double = 0.0
)