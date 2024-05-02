package com.challenge.postman.tareas.presentation.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Checkbox
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.challenge.postman.common.domain.navigation.Screen
import com.challenge.postman.tareas.presentation.TareasViewModel

@Composable
fun TareasDetallesScreen(
    modifier: Modifier = Modifier,
    viewModel: TareasViewModel,
    navController: NavController
) {
    val scrollState = rememberScrollState()
    val tarea by viewModel.tareaSeleccionada.observeAsState()
    var completadoState by remember { mutableStateOf(tarea?.completado) }


    Column(
        modifier = modifier
            .padding(4.dp)
            .verticalScroll(scrollState)
    ) {
        Row(
            modifier = modifier.padding(vertical = 8.dp),
        ) {
            Checkbox(
                checked = completadoState!!,
                onCheckedChange = {
                    completadoState = !completadoState!!
                    viewModel.updateTarea(tarea!!.apply { completado = completadoState!! })
                },
                modifier = modifier.padding(end = 8.dp)
            )
            Text(
                text = tarea!!.titulo,
                fontSize = 22.sp,
                modifier = modifier
                    .align(Alignment.CenterVertically)
                    .weight(1f)
            )
            IconButton(
                onClick = {
                    viewModel.deleteTarea(tarea!!)
                    navController.navigate(Screen.Tareas.route)
                }
            ) {
                Icon(imageVector = Icons.Filled.Delete, contentDescription = "Borrar tarea")
            }
        }
        HorizontalDivider()
        Column(
            modifier = modifier.padding(12.dp)
        ) {
            Text(
                text = "Descripción",
                fontWeight = FontWeight.ExtraBold,
                fontSize = 24.sp
            )
            Text(
                text = tarea!!.descripcion,
                modifier = modifier.padding(8.dp)
            )
        }
    }
}