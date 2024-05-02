package com.challenge.postman.common.presentation.ui

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.challenge.postman.common.domain.navigation.Screen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainAppBar(
    modifier: Modifier = Modifier,
    navController: NavController
) {
    val currentDestination = navController.currentBackStackEntryAsState().value?.destination?.route
    val titulo = when(currentDestination) {
        Screen.Home.route -> Screen.Home.title
        Screen.Tareas.route -> Screen.Tareas.title
        Screen.DetallesTarea.route -> Screen.DetallesTarea.title
        Screen.AgregarTarea.route -> Screen.AgregarTarea.title
        Screen.Ordenes.route -> Screen.Ordenes.title
        Screen.DetallesOrden.route -> Screen.DetallesOrden.title
        else -> ""
    }

    TopAppBar(
        title = {
            Text(text = titulo)
        },
        navigationIcon = {
            if(currentDestination != Screen.Home.route) {
                IconButton(
                    onClick = {
                        navController.navigateUp()
                    }
                ) {
                    Icon(imageVector = Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Atrás")
                }
            }
        }
    )
}