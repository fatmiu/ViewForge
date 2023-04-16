package com.miumiu.viewforge.ui.canvas_basic.ball_clicker_game

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier

@Composable
fun BallClickerScreen() {
    var points by remember {
        mutableStateOf(0)
    }
    var isTimerRunning by remember {
        mutableStateOf(false)
    }

    Column(modifier = Modifier.fillMaxSize()) {
        GameHud(
            points = points,
            isTimerRunning = isTimerRunning,
            onStartClick = {
                isTimerRunning = !isTimerRunning
                points = 0
            },
            onTimerEnd = {
                isTimerRunning = false
            })
        BallClicker(
            enabled = isTimerRunning
        ) {
            points++
        }
    }
}


