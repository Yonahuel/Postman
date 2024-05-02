package com.challenge.postman.ordenes.presentation.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import com.challenge.postman.ordenes.presentation.OrdenesViewModel

@Composable
fun DetallesOrdenes(
    viewModel: OrdenesViewModel,
) {
    val detalles by viewModel.orderDetails.observeAsState()
}