package com.miumiu.viewforge.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.miumiu.viewforge.util.Routes
import com.miumiu.viewforge.util.UiEvent

@Composable
fun ForgeScreen(
    padding: Dp,
    onNavigate: (UiEvent.Navigate) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Button(
            modifier = Modifier.padding(padding),
            onClick = { onNavigate(UiEvent.Navigate(Routes.BASIC_SHAPE)) }
        ) {
            Text(text = "basic shape")
        }
        Button(
            modifier = Modifier.padding(padding),
            onClick = { onNavigate(UiEvent.Navigate(Routes.BALL_CLICKER_GAME)) }
        ) {
            Text(text = "ball clicker game")
        }
        Button(
            modifier = Modifier.padding(padding),
            onClick = { onNavigate(UiEvent.Navigate(Routes.WEIGHT_PICKER)) }
        ) {
            Text(text = "weight picker")
        }
        Button(
            modifier = Modifier.padding(padding),
            onClick = { onNavigate(UiEvent.Navigate(Routes.CLOCK)) }
        ) {
            Text(text = "clock")
        }
        Button(
            modifier = Modifier.padding(padding),
            onClick = { onNavigate(UiEvent.Navigate(Routes.ROULETTE)) }
        ) {
            Text(text = "roulette")
        }
        Button(
            modifier = Modifier.padding(padding),
            onClick = { onNavigate(UiEvent.Navigate(Routes.BASIC_PATH)) }
        ) {
            Text(text = "basic path")
        }
        Button(
            modifier = Modifier.padding(padding),
            onClick = { onNavigate(UiEvent.Navigate(Routes.PATH_ANIM)) }
        ) {
            Text(text = "path anim")
        }
        Button(
            modifier = Modifier.padding(padding),
            onClick = { onNavigate(UiEvent.Navigate(Routes.PATH_EFFECT)) }
        ) {
            Text(text = "path effect")
        }
        Button(
            modifier = Modifier.padding(padding),
            onClick = { onNavigate(UiEvent.Navigate(Routes.PATH_DEMONSTRATION)) }
        ) {
            Text(text = "path demonstration")
        }
        Button(
            modifier = Modifier.padding(padding),
            onClick = { onNavigate(UiEvent.Navigate(Routes.GENDER_PICKER)) }
        ) {
            Text(text = "gender picker")
        }
        Button(
            modifier = Modifier.padding(padding),
            onClick = { onNavigate(UiEvent.Navigate(Routes.TIC_TAC_TOE)) }
        ) {
            Text(text = "tic tac toe")
        }
        Button(
            modifier = Modifier.padding(padding),
            onClick = { onNavigate(UiEvent.Navigate(Routes.BASIC_IMAGE)) }
        ) {
            Text(text = "basic image")
        }
        Button(
            modifier = Modifier.padding(padding),
            onClick = { onNavigate(UiEvent.Navigate(Routes.IMAGE_REVEAL)) }
        ) {
            Text(text = "image reveal")
        }
    }
}