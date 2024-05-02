package com.challenge.postman.common.presentation.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.challenge.postman.common.domain.navigation.Screen

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    navController: NavController
) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(Color.DarkGray)
    ) {
        Column(
            modifier = modifier.align(Alignment.Center)
        ) {
            ElevatedButton(
                modifier = modifier
                    .align(Alignment.CenterHorizontally)
                    .wrapContentSize(),
                onClick = { navController.navigate(Screen.Tareas.route) }
            ) {
                Text(
                    text = "Tareas",
                    fontWeight = FontWeight.ExtraBold,
                    fontSize = 32.sp
                )
            }

            Spacer(modifier = modifier.height(40.dp))

            ElevatedButton(
                modifier = modifier
                    .align(Alignment.CenterHorizontally)
                    .wrapContentSize(),
                onClick = { navController.navigate(Screen.Ordenes.route) }
            ) {
                Text(
                    text = "Órdenes",
                    fontWeight = FontWeight.ExtraBold,
                    fontSize = 32.sp
                )
            }
        }
    }
}