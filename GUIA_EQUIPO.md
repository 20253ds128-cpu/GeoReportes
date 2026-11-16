# Guía de Trabajo en Equipo - GeoReportes

Este documento define las reglas técnicas y de Git para mantener el código ordenado, evitar conflictos y avanzar en paralelo sin bloquearnos.

---

## 1. Arquitectura y Nivel de Código
El proyecto sigue el patrón **MVVM (Model - View - ViewModel)** con **Jetpack Compose**:
* **`model/`**: Clases de datos (`data class`).
* **`data/`**: Conexión con servicios externos (Firebase Firestore y GPS).
* **`ui/viewmodel/`**: Lógica de estado (`StateFlow`) que conecta los datos con las pantallas.
* **`ui/screens/`**: Interfaces gráficas en Jetpack Compose.

**Reglas de estilo:**
* Mantener el código claro, legible y acorde a lo visto en clase.
* Evitar librerías de inyección de dependencias complejas (no usar Hilt/Dagger) ni arquitecturas rebuscadas.
* Comentar brevemente los bloques nuevos (permisos de ubicación y consultas a Firestore) para que ambos podamos explicarlos.

---

## 2. División de Responsabilidades y Ramas

⚠️ **REGLA DE ORO:** La rama `main` está protegida. **Nadie hace `git push` directo a `main`.** Todo cambio entra mediante un *Pull Request (PR)* aprobado.

| Integrante | Rama asignada | Archivos permitidos | Tareas principales |
| :--- | :--- | :--- | :--- |
| **Líder / Backend** | `feature/firebase-vm` | `data/FirestoreRepository.kt`<br>`ui/viewmodel/ReporteViewModel.kt` | Guardar reportes en Firestore y escuchar cambios en tiempo real (`addSnapshotListener`). |
| **Colaborador / UI & Sensor** | `feature/gps-y-pantallas` | `data/LocationService.kt`<br>`ui/screens/ListaScreen.kt`<br>`ui/screens/CrearScreen.kt` | Solicitar permisos de GPS, obtener latitud/longitud y diseñar las pantallas en Compose. |

*(Nota: No modificar `build.gradle.kts` ni `AndroidManifest.xml` sin avisar antes al equipo, ya que son archivos compartidos).*

---

## 3. Flujo de Trabajo en Git (Paso a Paso)

### Al empezar tu tarea:
1. Asegúrate de estar en `main` actualizado:
   ```bash
   git checkout main
   git pull origin main