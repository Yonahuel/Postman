package com.challenge.postman.tareas.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.challenge.postman.common.domain.navigation.Screen
import com.challenge.postman.common.presentation.ListViewModel

@Composable
fun DetallesScreen(
    modifier: Modifier = Modifier,
    viewModel: ListViewModel,
    navController: NavController
) {
    val scrollState = rememberScrollState()
    val tarea by viewModel.tareaSeleccionada.observeAsState()

    Column(
        modifier = modifier
            .padding(4.dp)
            .verticalScroll(scrollState)
    ) {
        Row(
            modifier = modifier.padding(vertical = 8.dp)
        ) {
            Checkbox(
                checked = tarea!!.completado,
                onCheckedChange = {
                    viewModel.updateTarea(tarea!!.apply { completado = !completado })
                },
                modifier = modifier.padding(end = 8.dp)
            )
            Text(
                text = tarea!!.titulo!!,
                modifier = modifier.fillMaxWidth()
            )
            IconButton(
                onClick = {
                    viewModel.deleteTarea(tarea!!)
                    navController.navigate(Screen.Tareas.name)
                }
            ) {
                Icon(imageVector = Icons.Filled.Delete, contentDescription = "Borrar tarea")
            }
        }
        Text(
            text = tarea!!.descripcion ?: ""
        )
    }
}