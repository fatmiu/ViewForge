package com.miumiu.viewforge.ui.path_basic

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.PathOperation
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.ui.graphics.asAndroidPath
import androidx.compose.ui.graphics.asComposePath
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.drawscope.clipPath
import androidx.compose.ui.graphics.drawscope.rotate
import androidx.compose.ui.unit.dp
import kotlin.math.PI
import kotlin.math.atan2

@Composable
fun BasicPathScreen() {
//    BasicPath()
    PathOperations()
}

@Composable
fun BasicPath() {
    Canvas(modifier = Modifier.fillMaxSize()) {
        val path = Path().apply {
            moveTo(1000f, 100f)
            lineTo(100f, 500f)
            lineTo(500f, 500f)
//            quadraticBezierTo(800f, 300f, 500f, 100f)
            cubicTo(800f, 500f, 800f, 100f, 500f, 100f)
//            close()
        }
        drawPath(
            path = path,
            color = Color.Red,
            style = Stroke(
                width = 10.dp.toPx(),
                cap = StrokeCap.Round,
                join = StrokeJoin.Miter,
                miter = 5f
            )
        )
    }
}

@Composable
fun PathOperations() {
    Canvas(modifier = Modifier.fillMaxSize()) {
        val square = Path().apply {
            addRect(Rect(Offset(200f, 200f), Size(200f, 200f)))
        }
        val circle = Path().apply {
            addOval(Rect(Offset(200f, 200f), 100f))
        }
        val operation = Path().apply {
            op(square, circle, PathOperation.Difference)
        }
        drawPath(
            path = square,
            color = Color.Red,
            style = Stroke(width = 2.dp.toPx())
        )
        drawPath(
            path = circle,
            color = Color.Blue,
            style = Stroke(width = 2.dp.toPx())
        )
        drawPath(
            path = operation,
            color = Color.Green,
        )
    }
}

@Composable
fun TransformationsAndClipping() {
    Canvas(modifier = Modifier.fillMaxSize()) {
        /*
        translate(left = 300f, top = 300f) {
            rotate(45f, pivot = Offset(100f, 100f)) {
                scale(scale = 0.5f, pivot = Offset(200f, 200f)) {
                    drawRect(
                        color = Color.Red,
                        topLeft = Offset(100f, 100f),
                        size = Size(200f, 200f)
                    )
                }
            }
        }
        */

        val circle = Path().apply {
            addOval(Rect(center = Offset(400f, 400f), radius = 300f))
        }
        drawPath(
            path = circle,
            color = Color.Black,
            style = Stroke(width = 5.dp.toPx())
        )
        clipPath(
            path = circle
        ) {
            drawRect(
                color = Color.Red,
                topLeft = Offset(400f, 400f),
                size = Size(400f, 400f)
            )
        }
    }
}