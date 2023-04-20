package com.miumiu.viewforge.ui.canvas_basic

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.animation.ValueAnimator
import android.graphics.Paint
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.nativeCanvas
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.min
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.launch
import kotlin.math.cos
import kotlin.math.floor
import kotlin.math.sin
import kotlin.random.Random

@Composable
fun RouletteScreen() {
    var isRouletteRunning by remember {
        mutableStateOf(false)
    }

    val scope = rememberCoroutineScope()
    val snackBarHostState = remember { SnackbarHostState() }
    val items = listOf("Item 1", "Item 2", "Item 3", "Item 4", "Item 5", "Item 6")

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Roulette(
            enable = !isRouletteRunning,
            items = items,
            onRouletteStart = {
                isRouletteRunning = true
            },
            onItemSelected = {
                scope.launch {
                    snackBarHostState.showSnackbar(it)
                    isRouletteRunning = false
                }
            }
        )
    }

    SnackbarHost(hostState = snackBarHostState)
}

@Composable
fun Roulette(
    modifier: Modifier = Modifier,
    enable: Boolean = false,
    items: List<String>,
    onRouletteStart: (() -> Unit)? = null,
    onItemSelected: (String) -> Unit
) {
    var currentAngle by remember { mutableStateOf(0f) }

    Box(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        contentAlignment = Alignment.Center
    ) {
        BoxWithConstraints {
            val diameter = min(maxWidth, maxHeight)
            val radius = diameter / 2f
            val sweepAngle = 360f / items.size

            Canvas(
                modifier = Modifier
                    .size(diameter)
                    .pointerInput(enable) {
                        if (!enable) {
                            return@pointerInput
                        }
                        detectTapGestures {
                            val randomAngle = Random
                                .nextDouble(360.0)
                                .toFloat() + 360 * 3
                            val targetAngle = currentAngle + randomAngle
                            val anim = ValueAnimator
                                .ofFloat(currentAngle, targetAngle)
                                .apply {
                                    duration = 3000
                                    addUpdateListener { animator ->
                                        currentAngle = animator.animatedValue as Float
                                    }
                                    addListener(object : AnimatorListenerAdapter() {
                                        override fun onAnimationEnd(animation: Animator) {
                                            super.onAnimationEnd(animation)
                                            val selectAngle = currentAngle
                                            val arrowAngle =
                                                90 - (selectAngle - ((selectAngle / 360).toInt() * 360))
                                            val selectedIndex = if (arrowAngle > 0) {
                                                floor(arrowAngle / sweepAngle).toInt()
                                            } else {
                                                floor((arrowAngle + 360) / sweepAngle).toInt()
                                            }
                                            onItemSelected(items[selectedIndex])
                                        }
                                    })
                                }
                            anim.start()
                            onRouletteStart?.invoke()
                        }
                    }
            ) {
                var startAngle = currentAngle

                drawCircle(color = Color.LightGray, radius = radius.toPx())

                for (index in items.indices) {
                    val item = items[index]
                    val endAngle = startAngle + sweepAngle

                    drawArc(
                        color = if (index % 2 == 0) Color.Blue else Color.Red,
                        startAngle = startAngle,
                        sweepAngle = sweepAngle,
                        useCenter = true,
                        topLeft = Offset(
                            (radius - diameter / 2f).toPx(),
                            (radius - diameter / 2f).toPx()
                        ),
                        size = Size((diameter).toPx(), (diameter).toPx())
                    )

                    val itemAngle = (startAngle + endAngle) / 2f
                    val itemX = radius + (radius - diameter / 5f) * cos(itemAngle.toRadians())
                    val itemY = radius + (radius - diameter / 5f) * sin(itemAngle.toRadians())

                    drawContext.canvas.nativeCanvas.apply {
                        drawText(
                            item,
                            itemX.toPx(),
                            itemY.toPx(),
                            Paint().apply {
                                color = Color.Black.toArgb()
                                textSize = 16.sp.toPx()
                                textAlign = Paint.Align.CENTER
                            }
                        )
                    }
                    startAngle = endAngle
                }

                val trianglePath = Path().apply {
                    moveTo((diameter / 2f).toPx(), (diameter - 8.dp).toPx())
                    lineTo((diameter / 2f - 8.dp).toPx(), (diameter + 8.dp).toPx())
                    lineTo((diameter / 2f + 8.dp).toPx(), (diameter + 8.dp).toPx())
                }
                drawPath(
                    color = Color.Green,
                    path = trianglePath
                )
            }
        }
    }
}

private fun Float.toRadians() = Math.toRadians(this.toDouble()).toFloat()
