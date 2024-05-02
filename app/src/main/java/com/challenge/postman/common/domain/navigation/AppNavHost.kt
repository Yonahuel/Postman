package com.challenge.postman.common.domain.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.challenge.postman.common.presentation.ui.HomeScreen
import com.challenge.postman.ordenes.presentation.OrdenesViewModel
import com.challenge.postman.ordenes.presentation.ui.DetallesOrdenes
import com.challenge.postman.ordenes.presentation.ui.ListadoOrdenes
import com.challenge.postman.tareas.presentation.TareasViewModel
import com.challenge.postman.tareas.presentation.ui.AgregarTarea
import com.challenge.postman.tareas.presentation.ui.TareasDetallesScreen
import com.challenge.postman.tareas.presentation.ui.TareasScreen

@Composable
fun AppNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    padding: PaddingValues,
    tareasViewModel: TareasViewModel,
    ordenesViewModel: OrdenesViewModel
) {
    NavHost(
        navController = navController,
        startDestination = Screen.Home.route,
        modifier = modifier.padding(padding)
    ) {
        composable(Screen.Home.route) {
            HomeScreen(navController = navController)
        }
        composable(Screen.Tareas.route) {
            TareasScreen(viewModel = tareasViewModel, navController = navController)
        }
        composable(Screen.DetallesTarea.route) {
            TareasDetallesScreen(viewModel = tareasViewModel, navController = navController)
        }
        composable(Screen.AgregarTarea.route) {
            AgregarTarea(viewModel = tareasViewModel, navController = navController)
        }
        composable(Screen.Ordenes.route) {
            ListadoOrdenes(viewModel = ordenesViewModel, navController = navController)
        }
        composable(Screen.DetallesOrden.route) {
            DetallesOrdenes(viewModel = ordenesViewModel)
        }
    }
}