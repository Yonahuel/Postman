package com.challenge.postman.common.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.challenge.postman.common.domain.navigation.AppNavHost
import com.challenge.postman.common.presentation.theme.PostmanTheme
import com.challenge.postman.common.presentation.ui.MainAppBar
import com.challenge.postman.ordenes.presentation.OrdenesViewModel
import com.challenge.postman.tareas.presentation.TareasViewModel
import com.challenge.postman.tareas.presentation.ui.BotonAgregarTarea
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val tareasViewModel: TareasViewModel by viewModels()
    private val ordenesViewModel: OrdenesViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()
        setContent {
            PostmanTheme {
                MainApp(
                    tareasViewModel = tareasViewModel,
                    ordenesViewModel = ordenesViewModel
                )
            }
        }
    }
}

@Composable
fun MainApp(
    modifier: Modifier = Modifier,
    tareasViewModel: TareasViewModel,
    ordenesViewModel: OrdenesViewModel
) {
    val navController = rememberNavController()

    Scaffold(
        modifier = modifier.fillMaxSize(),
        topBar = {
            MainAppBar(navController = navController)
        },
        content = { innerPadding ->
            AppNavHost(
                navController = navController,
                padding = innerPadding,
                tareasViewModel = tareasViewModel,
                ordenesViewModel = ordenesViewModel
            )
        },
        floatingActionButton = {
            BotonAgregarTarea(navController = navController)
        }
    )
}