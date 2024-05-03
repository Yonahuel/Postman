package com.challenge.postman.tareas.presentation.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material3.Checkbox
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.HorizontalDivider
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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.challenge.postman.common.domain.navigation.Screen
import com.challenge.postman.tareas.data.entities.Tarea
import com.challenge.postman.tareas.presentation.TareasViewModel

@Composable
fun TareasScreen(
    modifier: Modifier = Modifier,
    viewModel: TareasViewModel,
    navController: NavController
) {
    val tareas by viewModel.allTareas.observeAsState()
    val completadas = tareas?.filter { it.completado }
    val pendientes = tareas?.filter { !it.completado }
    var mostrarCompletados by remember { mutableStateOf(true) }

    Column(
        modifier = modifier.padding(4.dp)
    ) {
        LazyColumn {
            if (!pendientes.isNullOrEmpty()) {
                items(pendientes) { tarea ->
                    TareaItem(
                        tarea = tarea,
                        viewModel = viewModel,
                        navController = navController
                    )
                }
            }
        }
        if (!completadas.isNullOrEmpty()) {
            HorizontalDivider(
                modifier.padding(top = 12.dp)
            )
            Row(
                modifier = modifier.align(Alignment.Start)
            ) {
                IconButton(
                    onClick = { mostrarCompletados = !mostrarCompletados },
                    modifier = modifier
                        .padding(end = 4.dp)
                        .align(Alignment.CenterVertically)
                ) {
                    Icon(
                        imageVector = if (mostrarCompletados) {
                            Icons.Filled.KeyboardArrowDown
                        } else {
                            Icons.AutoMirrored.Filled.KeyboardArrowRight
                        },
                        contentDescription = "Mostrar completados")
                }
                Text(
                    text = "Completado ${completadas.size}",
                    modifier = modifier.align(Alignment.CenterVertically)
                )
            }

            if (mostrarCompletados) {
                LazyColumn {
                    items(completadas) { tarea ->
                        TareaItem(
                            tarea = tarea,
                            viewModel = viewModel,
                            navController = navController
                        )
                    }
                }
            }
        }
    }
}

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun TareaItem(
    modifier: Modifier = Modifier,
    tarea: Tarea,
    viewModel: TareasViewModel,
    navController: NavController
) {
    val textStyle: TextStyle = if (tarea.completado) {
        TextStyle(textDecoration = TextDecoration.LineThrough)
    } else {
        TextStyle()
    }
    var completadoState by remember { mutableStateOf(tarea.completado) }

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
                checked = completadoState,
                onCheckedChange = {
                    completadoState = !completadoState
                    viewModel.updateTarea(tarea.apply { completado = completadoState })
                }
            )
            Text(
                text = tarea.titulo,
                fontSize = 22.sp,
                style = textStyle,
                modifier = modifier
                    .align(Alignment.CenterVertically)
                    .weight(1f)
                    .clickable {
                        viewModel.seleccionarTarea(tarea)
                        navController.navigate(Screen.DetallesTarea.route)
                    }
            )
            GlideImage(
                model = tarea.imagen,
                contentDescription = "Imagen",
                contentScale = ContentScale.Crop,
                modifier = modifier.size(40.dp)
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
        descripcion = "Descripción",
        imagen = ""
    )

    //TareaItem(tarea = tarea)
}