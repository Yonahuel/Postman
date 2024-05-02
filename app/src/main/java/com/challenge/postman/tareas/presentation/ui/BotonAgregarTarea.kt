package com.challenge.postman.tareas.presentation.ui

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.challenge.postman.common.domain.navigation.Screen

@Composable
fun BotonAgregarTarea(
    navController: NavController
) {
    val currentDestination = navController.currentBackStackEntryAsState().value?.destination?.route

    if (currentDestination == Screen.Tareas.route) {
        FloatingActionButton(
            onClick = {
                navController.navigate(Screen.AgregarTarea.route)
            }
        ) {
            Icon(imageVector = Icons.Filled.Add, contentDescription = "Agregar Tarea")
        }
    }
}