package com.miumiu.viewforge.ui.image_basic

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.ClipOp
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.clipPath
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.IntSize
import com.miumiu.viewforge.R
import kotlin.math.roundToInt

@Composable
fun ImageRevealScreen() {
    ImageReveal()
}

@Composable
fun ImageReveal() {
    var circlePos by remember {
        mutableStateOf(Offset.Zero)
    }

    var oldCirclePos by remember {
        mutableStateOf(Offset.Zero)
    }
    val imageBmp = ImageBitmap.imageResource(id = R.drawable.cat)
    val radius = 200f
    Canvas(modifier = Modifier
        .fillMaxSize()
        .pointerInput(true) {
            detectDragGestures(
                onDragEnd = {
                    oldCirclePos = circlePos
                }
            ) { change, _ ->
                circlePos = oldCirclePos + change.position
            }
        }
    ) {
        val bmpHeight =
            ((imageBmp.height.toFloat() / imageBmp.width.toFloat()) * size.width).roundToInt()
        val circlePath = Path().apply {
            addArc(
                oval = Rect(circlePos, radius),
                startAngleDegrees = 0f,
                sweepAngleDegrees = 360f
            )
        }
        drawImage(
            image = imageBmp,
            dstSize = IntSize(
                size.width.roundToInt(),
                bmpHeight
            ),
            dstOffset = IntOffset(0, center.y.roundToInt() - bmpHeight / 2),
            colorFilter = ColorFilter.tint(Color.Black, BlendMode.Color)
        )
        clipPath(circlePath, clipOp = ClipOp.Intersect) {
            drawImage(
                image = imageBmp,
                dstSize = IntSize(
                    size.width.roundToInt(),
                    bmpHeight
                ),
                dstOffset = IntOffset(0, center.y.roundToInt() - bmpHeight / 2),
            )
        }
    }
}
