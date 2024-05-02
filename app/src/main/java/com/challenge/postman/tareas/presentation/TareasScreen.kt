package com.challenge.postman.tareas.presentation

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Card
import androidx.compose.material3.Checkbox
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.challenge.postman.common.presentation.ListViewModel
import com.challenge.postman.tareas.data.entities.Tarea

@Composable
fun TareasScreen(
    viewModel: ListViewModel
) {
    val tareas by viewModel.allTareas.observeAsState()

    LazyColumn {
        if (!tareas.isNullOrEmpty()) {
            items(tareas!!) { tarea ->
                TareaItem(
                    tarea = tarea,
                    viewModel = viewModel
                )
            }
        }
    }
}

@Composable
fun TareaItem(
    modifier: Modifier = Modifier,
    tarea: Tarea,
    viewModel: ListViewModel
) {
    var checked by remember { mutableStateOf(false) }

    ElevatedCard(
        modifier = modifier
            .padding(4.dp)
            .fillMaxWidth()
    ) {
        Row(
            modifier = modifier.padding(4.dp)
        ) {
            Checkbox(
                modifier = modifier.padding(end = 4.dp),
                checked = checked,
                onCheckedChange = {
                    checked = !checked
                }
            )
            Text(
                text = tarea.titulo!!,
                modifier = modifier
                    .align(Alignment.CenterVertically)
                    .fillMaxWidth()
                    .clickable {
                        TODO()
                    }
            )
            IconButton(
                modifier = modifier
                    .align(Alignment.CenterVertically)
                    .padding(start = 4.dp),
                onClick = {
                    viewModel.deleteTarea(tarea)
                }
            ) {
                Icon(imageVector = Icons.Filled.Delete, contentDescription = "Borrar tarea")
            }
        }
    }
}

@Preview
@Composable
fun TareaItemPreview() {
    val tarea = Tarea(
        id = 0,
        titulo = "Nueva Tarea",
        descripcion = "Descripción"
    )

    //TareaItem(tarea = tarea)
}