package com.miumiu.viewforge.ui.canvas_basic

import android.graphics.Paint
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.rotate
import androidx.compose.ui.graphics.nativeCanvas
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay
import kotlin.math.PI
import kotlin.math.cos
import kotlin.math.sin

@Composable
fun ClockScreen() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        val milliseconds = remember {
            System.currentTimeMillis()
        }
        var seconds by remember {
            mutableStateOf(milliseconds / 1000f % 60f)
        }
        var minutes by remember {
            mutableStateOf((milliseconds / 1000f) / 60 % 60f)
        }
        var hours by remember {
            mutableStateOf((milliseconds / 1000f) / 3600 + 8f)
        }
        LaunchedEffect(key1 = seconds) {
            delay(1000L)
            minutes += 1f / 60f
            hours += 1f / (60f * 60f * 12f)
            seconds += 1f
        }
        Clock(
            seconds = seconds,
            minutes = minutes,
            hours = hours
        )
    }
}

@Composable
fun Clock(
    seconds: Float = 0f,
    minutes: Float = 0f,
    hours: Float = 0f,
    radius: Dp = 100.dp
) {
    Canvas(modifier = Modifier.size(radius * 2f)) {
        drawContext.canvas.nativeCanvas.apply {
            drawCircle(
                center.x,
                center.y,
                radius.toPx(),
                Paint().apply {
                    color = android.graphics.Color.WHITE
                    setShadowLayer(
                        50f,
                        0f,
                        0f,
                        android.graphics.Color.argb(50, 0, 0, 0)
                    )
                }
            )
        }

        for (i in 0..59) {
            val angleInRadius = i * (360f / 60f) * (PI.toFloat() / 180f)
            val lineLength = if (i % 5 == 0) 20.dp.toPx() else 15.dp.toPx()
            val strokeWidth = if (i % 5 == 0) 1.dp.toPx() else 0.5.dp.toPx()
            val color =
                if (i % 5 == 0) Color.DarkGray
                else Color.Gray

            val lineStart = Offset(
                x = radius.toPx() * cos(angleInRadius) + center.x,
                y = radius.toPx() * sin(angleInRadius) + center.y,
            )
            val lineEnd = Offset(
                x = (radius.toPx() - lineLength) * cos(angleInRadius) + center.x,
                y = (radius.toPx() - lineLength) * sin(angleInRadius) + center.y,
            )
            drawLine(
                color = color,
                start = lineStart,
                end = lineEnd,
                strokeWidth = strokeWidth
            )
        }

        rotate(degrees = seconds * (360f / 60f)) {
            drawLine(
                color = Color.Red,
                start = center,
                end = Offset(center.x, 20.dp.toPx()),
                strokeWidth = 2.dp.toPx(),
                cap = StrokeCap.Round
            )
        }
        rotate(degrees = minutes * (360f / 60f)) {
            drawLine(
                color = Color.Black,
                start = center,
                end = Offset(center.x, 35.dp.toPx()),
                strokeWidth = 3.dp.toPx(),
                cap = StrokeCap.Round
            )
        }
        rotate(degrees = hours * (360f / 12f)) {
            drawLine(
                color = Color.Black,
                start = center,
                end = Offset(center.x, 50.dp.toPx()),
                strokeWidth = 4.dp.toPx(),
                cap = StrokeCap.Round
            )
        }
    }
}