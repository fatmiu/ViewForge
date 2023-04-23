package com.miumiu.viewforge.ui.path_basic

import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.graphics.StampedPathEffectStyle
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.unit.dp


@Composable
fun PathEffectScreen() {
    DashPathEffectSample()
}

@Composable
fun DashPathEffectSample() {
    val infiniteTransition = rememberInfiniteTransition()
    val phase by infiniteTransition.animateFloat(
        initialValue = 0f,
        targetValue = 10000f,
        animationSpec = infiniteRepeatable(
            animation = tween(60000, easing = LinearEasing)
        )
    )
    Canvas(modifier = Modifier.fillMaxSize()) {
        val path = Path().apply {
            moveTo(100f, 100f)
            cubicTo(100f, 300f, 600f, 700f, 600f, 1100f)
        }
        drawPath(
            path = path,
            color = Color.Red,
            style = Stroke(
                width = 5.dp.toPx(),
                pathEffect = PathEffect.dashPathEffect(
                    intervals = floatArrayOf(50f, 30f),
                    phase = phase
                )
            )
        )
    }
}

@Composable
fun CornerPathEffectSample() {
    Canvas(modifier = Modifier.fillMaxSize()) {
        val path = Path().apply {
            moveTo(100f, 100f)
            cubicTo(100f, 300f, 600f, 700f, 600f, 1100f)
            lineTo(800f, 800f)
            lineTo(1000f, 1100f)
        }
        drawPath(
            path = path,
            color = Color.Red,
            style = Stroke(
                width = 5.dp.toPx(),
                pathEffect = PathEffect.cornerPathEffect(
                    1000f
                )
            )
        )
    }
}

@Composable
fun StampedPathEffectSample() {
    val infiniteTransition = rememberInfiniteTransition()
    val phase by infiniteTransition.animateFloat(
        initialValue = 0f,
        targetValue = 10000f,
        animationSpec = infiniteRepeatable(
            animation = tween(60000, easing = LinearEasing)
        )
    )
    Canvas(modifier = Modifier.fillMaxSize()) {
        val path = Path().apply {
            moveTo(100f, 100f)
            cubicTo(100f, 300f, 600f, 700f, 600f, 1100f)
            lineTo(800f, 800f)
            lineTo(1000f, 1100f)
        }
        val oval = Path().apply {
            addOval(Rect(topLeft = Offset.Zero, bottomRight = Offset(40f, 10f)))
        }
        drawPath(
            path = path,
            color = Color.Red,
            style = Stroke(
                width = 5.dp.toPx(),
                pathEffect = PathEffect.stampedPathEffect(
                    shape = oval,
                    advance = 100f,
                    phase = phase,
                    style = StampedPathEffectStyle.Rotate
                )
            )
        )
    }
}

@Composable
fun ChainPathEffectSample() {
    val infiniteTransition = rememberInfiniteTransition()
    val phase by infiniteTransition.animateFloat(
        initialValue = 0f,
        targetValue = 10000f,
        animationSpec = infiniteRepeatable(
            animation = tween(60000, easing = LinearEasing)
        )
    )
    Canvas(modifier = Modifier.fillMaxSize()) {
        val path = Path().apply {
            moveTo(100f, 100f)
            cubicTo(100f, 300f, 600f, 700f, 600f, 1100f)
            lineTo(800f, 800f)
            lineTo(1000f, 1100f)
        }
        val oval = Path().apply {
            addOval(Rect(topLeft = Offset.Zero, bottomRight = Offset(40f, 10f)))
        }
        drawPath(
            path = path,
            color = Color.Red,
            style = Stroke(
                width = 5.dp.toPx(),
                pathEffect = PathEffect.chainPathEffect(
                    outer = PathEffect.stampedPathEffect(
                        shape = oval,
                        advance = 30f,
                        phase = 0f,
                        style = StampedPathEffectStyle.Rotate
                    ),
                    inner = PathEffect.dashPathEffect(
                        intervals = floatArrayOf(100f, 100f)
                    )
                )
            )
        )
    }
}