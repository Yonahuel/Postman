package com.challenge.postman.tareas.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.challenge.postman.common.domain.navigation.Screen
import com.challenge.postman.tareas.data.entities.Tarea

@Composable
fun AgregarTarea(
    modifier: Modifier = Modifier,
    viewModel: TareasViewModel,
    navController: NavController
) {
    val titulo = remember { mutableStateOf(TextFieldValue()) }
    val descripcion = remember { mutableStateOf(TextFieldValue()) }
    val scrollState = rememberScrollState()

    Column(
        modifier = modifier.padding(8.dp)
    ) {
        Column(
            modifier = modifier
                .fillMaxHeight()
                .verticalScroll(scrollState)
        ) {
            TextField(
                value = titulo.value,
                onValueChange = {
                    titulo.value = it
                },
                label = { Text(text = "Título") },
                modifier = modifier
                    .fillMaxWidth()
                    .padding(bottom = 8.dp)
            )
            TextField(
                value = descripcion.value,
                onValueChange = {
                    descripcion.value = it
                },
                label = { Text(text = "Descripción") },
                modifier = modifier.fillMaxWidth()
            )

        }
        IconButton(
            onClick = {
                val tarea = Tarea(
                    titulo = titulo.value.text,
                    descripcion = descripcion.value.text,
                    completado = false
                )
                viewModel.insertTarea(tarea)
                titulo.value = TextFieldValue()
                descripcion.value = TextFieldValue()
                navController.navigate(Screen.Tareas.name)
            },
            modifier = modifier
                .align(Alignment.CenterHorizontally)
                .padding(vertical = 8.dp)
        ) {
            Text(
                text = "Guardar",
                modifier = modifier.padding(4.dp)
            )
        }
    }
}