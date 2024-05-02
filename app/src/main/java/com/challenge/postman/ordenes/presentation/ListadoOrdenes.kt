package com.challenge.postman.ordenes.presentation

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.challenge.postman.common.domain.navigation.Screen
import com.challenge.postman.ordenes.data.network.api_entities.Order

@Composable
fun ListadoOrdenes(
    viewModel: OrdenesViewModel,
    navController: NavController,
) {
    val ordenes by viewModel.todayOrders.observeAsState()

    LazyColumn {
        items(ordenes!!) { orden ->
            OrdenItem(
                orden = orden,
                navController = navController,
                viewModel = viewModel
            )
        }
    }
}

@Composable
fun OrdenItem(
    modifier: Modifier = Modifier,
    orden: Order,
    navController: NavController,
    viewModel: OrdenesViewModel
) {
    ElevatedCard(
        onClick = {
            viewModel.getOrderDetails()
            navController.navigate(Screen.DetallesOrden.name)
        },
        modifier = modifier
            .padding(4.dp)
            .fillMaxWidth()
    ) {
        Row(
            modifier = modifier.padding(4.dp)
        ) {
            Text(text = "")
        }
    }
}