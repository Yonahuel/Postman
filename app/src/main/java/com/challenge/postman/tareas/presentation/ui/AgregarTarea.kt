package com.challenge.postman.tareas.presentation.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.challenge.postman.common.domain.navigation.Screen
import com.challenge.postman.tareas.presentation.TareasViewModel

@Composable
fun AgregarTarea(
    modifier: Modifier = Modifier,
    viewModel: TareasViewModel,
    navController: NavController
) {
    val titulo = remember { mutableStateOf(TextFieldValue()) }
    val descripcion = remember { mutableStateOf(TextFieldValue()) }
    val imagen = remember { mutableStateOf(TextFieldValue()) }
    val scrollState = rememberScrollState()

    Column(
        modifier = modifier.padding(8.dp)
    ) {
        Column(
            modifier = modifier
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
                    .padding(bottom = 12.dp)
            )
            TextField(
                value = descripcion.value,
                onValueChange = {
                    descripcion.value = it
                },
                label = { Text(text = "Descripción") },
                modifier = modifier
                    .fillMaxWidth()
                    .padding(bottom = 12.dp)
            )
            TextField(
                value = imagen.value,
                onValueChange = {
                    imagen.value = it
                },
                label = { Text(text = "Url de la imagen") },
                modifier = modifier.fillMaxWidth()
            )
        }
        Button(
            onClick = {
                viewModel.insertTarea(
                    titulo = titulo.value.text,
                    descripcion = descripcion.value.text,
                    imagen = ""
                )
                titulo.value = TextFieldValue()
                descripcion.value = TextFieldValue()
                navController.navigate(Screen.Tareas.route)
            },
            modifier = modifier
                .align(Alignment.CenterHorizontally)
                .padding(12.dp)
                .wrapContentSize(),
            colors = ButtonColors(
                containerColor = Color.Blue,
                contentColor = Color.White,
                disabledContentColor = Color.White,
                disabledContainerColor = Color.Blue
            )
        ) {
            Text(
                text = "Guardar",
            )
        }
    }
}