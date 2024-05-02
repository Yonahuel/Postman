package com.challenge.postman.ordenes.presentation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import com.challenge.postman.ordenes.data.network.api_entities.Order

@Composable
fun DetallesOrdenes(
    viewModel: OrdenesViewModel,
) {
    val detalles by viewModel.orderDetails.observeAsState()
}