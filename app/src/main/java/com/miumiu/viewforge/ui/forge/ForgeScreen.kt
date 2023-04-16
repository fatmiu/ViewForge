package com.miumiu.viewforge.ui.forge

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.miumiu.viewforge.util.Routes
import com.miumiu.viewforge.util.UiEvent

@Composable
fun ForgeScreen(
    onNavigate: (UiEvent.Navigate) -> Unit
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(
            modifier = Modifier.padding(16.dp),
            onClick = { onNavigate(UiEvent.Navigate(Routes.BASIC_SHAPE)) }
        ) {
            Text(text = "basic shape")
        }
    }
}