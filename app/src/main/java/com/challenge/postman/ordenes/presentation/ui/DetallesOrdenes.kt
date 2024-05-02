package com.challenge.postman.ordenes.presentation.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.platform.LocalContext
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.challenge.postman.ordenes.presentation.OrdenesViewModel

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun DetallesOrdenes(
    viewModel: OrdenesViewModel,
) {
    val detalles by viewModel.orderDetails.observeAsState()
    val url = ""
    val context = LocalContext.current

    Column {
        GlideImage(
            model = url,
            contentDescription = "Imagen",
        )
    }
}