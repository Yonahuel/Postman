package com.challenge.postman

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
import com.challenge.postman.common.presentation.ListViewModel
import com.challenge.postman.common.presentation.theme.PostmanTheme
import com.challenge.postman.tareas.presentation.AgregarTarea
import com.challenge.postman.tareas.presentation.DetallesScreen
import com.challenge.postman.tareas.presentation.TareasScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val viewModel = ViewModelProvider(this)[ListViewModel::class.java]

        enableEdgeToEdge()
        setContent {
            PostmanTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    MainApp(
                        modifier = Modifier.padding(innerPadding),
                        viewModel = viewModel
                    )
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainApp(
    modifier: Modifier = Modifier,
    viewModel: ListViewModel
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
                    TareasScreen(viewModel = viewModel, navController = navController)
                }
                composable(Screen.Detalles.name) {
                    DetallesScreen(viewModel = viewModel, navController = navController)
                }
                composable(Screen.AgregarTarea.name) {
                    AgregarTarea(viewModel = viewModel, navController = navController)
                }
            }
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = { /*TODO*/ }
            ) {
                Icon(imageVector = Icons.Filled.Add, contentDescription = "Agregar Tarea")
            }
        }
    )
}