package com.challenge.postman.common.presentation

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.challenge.postman.common.domain.navigation.Screen
import com.challenge.postman.tareas.presentation.TareasViewModel
import com.challenge.postman.common.presentation.theme.PostmanTheme
import com.challenge.postman.ordenes.presentation.DetallesOrdenes
import com.challenge.postman.ordenes.presentation.ListadoOrdenes
import com.challenge.postman.ordenes.presentation.OrdenesViewModel
import com.challenge.postman.tareas.presentation.AgregarTarea
import com.challenge.postman.tareas.presentation.DetallesScreen
import com.challenge.postman.tareas.presentation.TareasScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val tareasViewModel = ViewModelProvider(this)[TareasViewModel::class.java]
        val ordenesViewModel = ViewModelProvider(this)[OrdenesViewModel::class.java]

        enableEdgeToEdge()
        setContent {
            PostmanTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    MainApp(
                        modifier = Modifier.padding(innerPadding),
                        tareasViewModel = tareasViewModel,
                        ordenesViewModel = ordenesViewModel
                    )
                }
            }
        }
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainApp(
    modifier: Modifier = Modifier,
    tareasViewModel: TareasViewModel,
    ordenesViewModel: OrdenesViewModel
) {
    val navController = rememberNavController()

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = "Home Screen")
                },
                navigationIcon = {
                    IconButton(
                        onClick = {
                            navController.navigateUp()
                        }
                    ) {
                        Icon(imageVector = Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Atrás")
                    }
                }
            )
        },
        content = {
            NavHost(navController = navController, startDestination = Screen.Tareas.name) {
                composable(Screen.Tareas.name) {
                    TareasScreen(viewModel = tareasViewModel, navController = navController)
                }
                composable(Screen.DetallesTarea.name) {
                    DetallesScreen(viewModel = tareasViewModel, navController = navController)
                }
                composable(Screen.AgregarTarea.name) {
                    AgregarTarea(viewModel = tareasViewModel, navController = navController)
                }
                composable(Screen.Ordenes.name) {
                    ListadoOrdenes(viewModel = ordenesViewModel, navController = navController)
                }
                composable(Screen.DetallesOrden.name) {
                    DetallesOrdenes(viewModel = ordenesViewModel)
                }
            }
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    navController.navigate(Screen.AgregarTarea.name)
                }
            ) {
                Icon(imageVector = Icons.Filled.Add, contentDescription = "Agregar Tarea")
            }
        }
    )
}