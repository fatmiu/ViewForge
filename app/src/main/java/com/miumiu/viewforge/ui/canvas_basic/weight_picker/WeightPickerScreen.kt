package com.miumiu.viewforge.ui.canvas_basic.weight_picker

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun WeightPickerScreen() {
    var weight by remember {
        mutableStateOf(80)
    }
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            modifier = Modifier.padding(32.dp),
            text = "$weight",
            fontSize = 40.sp
        )
        WeightPicker(
            modifier = Modifier
                .fillMaxWidth()
                .height(300.dp),
            style = ScaleStyle(
                scaleWidth = 150.dp
            )
        ) {
            weight = it
        }
    }
}