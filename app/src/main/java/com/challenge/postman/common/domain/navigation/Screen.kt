package com.challenge.postman.common.domain.navigation

enum class Screen(val route: String, val title: String) {
    Home("home", "Pantalla de inicio"),
    Tareas("tareas", "Listado de tareas"),
    DetallesTarea("detalles_tarea", "Detalles de tarea"),
    AgregarTarea("agregar_tarea", "Agregar tarea"),
    Ordenes("ordenes", "Listado de órdenes"),
    DetallesOrden("detalles_orden", "Detalles de órden")
}