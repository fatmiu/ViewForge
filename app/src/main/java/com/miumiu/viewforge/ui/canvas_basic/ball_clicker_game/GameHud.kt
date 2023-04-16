package com.miumiu.viewforge.ui.canvas_basic.ball_clicker_game

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun GameHud(
    points: Int,
    isTimerRunning: Boolean,
    onStartClick: () -> Unit = {},
    onTimerEnd: () -> Unit = {}
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = "Points: $points",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold
        )
        Button(onClick = {
            onStartClick()
        }) {
            Text(text = if (isTimerRunning) "Reset" else "Start")
        }
        CountDownTimer(
            isTimerRunning = isTimerRunning
        ) {
            onTimerEnd()
        }
    }
}
