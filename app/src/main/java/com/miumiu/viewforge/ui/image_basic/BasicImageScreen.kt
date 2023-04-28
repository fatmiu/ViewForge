package com.miumiu.viewforge.ui.image_basic

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.IntSize
import com.miumiu.viewforge.R

@Composable
fun BasicImageScreen() {
    BasicImage()
}

@Composable
fun BasicImage() {
    val cat = ImageBitmap.imageResource(id = R.drawable.cat)
    Canvas(modifier = Modifier.fillMaxSize()) {
        drawImage(
            image = cat,
            dstOffset = IntOffset(100, 100),
            dstSize = IntSize(
                (400 * (cat.width.toFloat() / cat.height)).toInt(),
                400
            )
        )
        drawCircle(
            color = Color.Red,
            radius = 200f,
            center = Offset(300f,300f),
            blendMode = BlendMode.Color
        )
    }
}