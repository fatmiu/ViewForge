package com.miumiu.viewforge.ui.path_basic.tictactoe

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun TicTacToeScreen() {
    var winningPlayer by remember {
        mutableStateOf<Player?>(null)
    }
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TicTacToe(
            onNewRound = {
                winningPlayer = null
            },
            onPlayerWin = {
                winningPlayer = it
            }
        )
        Spacer(modifier = Modifier.height(50.dp))

        winningPlayer?.let {
            Text(
                text = "Player ${it.symbol} has won!",
                fontSize = 25.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }

}