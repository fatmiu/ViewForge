package com.miumiu.viewforge

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.miumiu.viewforge.ui.canvas_basic.BallClickerGameScreen
import com.miumiu.viewforge.ui.canvas_basic.BasicShapeScreen
import com.miumiu.viewforge.ui.canvas_basic.ClockScreen
import com.miumiu.viewforge.ui.canvas_basic.RouletteScreen
import com.miumiu.viewforge.ui.canvas_basic.weight_picker.WeightPickerScreen
import com.miumiu.viewforge.ui.ForgeScreen
import com.miumiu.viewforge.ui.image_basic.BasicImageScreen
import com.miumiu.viewforge.ui.image_basic.ImageRevealScreen
import com.miumiu.viewforge.ui.path_basic.BasicPathScreen
import com.miumiu.viewforge.ui.path_basic.PathAnimScreen
import com.miumiu.viewforge.ui.path_basic.PathDemonstrationScreen
import com.miumiu.viewforge.ui.path_basic.PathEffectScreen
import com.miumiu.viewforge.ui.path_basic.gender_picker.GenderPickerScreen
import com.miumiu.viewforge.ui.path_basic.tictactoe.TicTacToeScreen
import com.miumiu.viewforge.ui.theme.ViewForgeTheme
import com.miumiu.viewforge.util.Routes

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ViewForgeTheme {
                val navController = rememberNavController()
                NavHost(navController = navController, startDestination = Routes.FORGE) {
                    composable(Routes.FORGE) {
                        ForgeScreen(
                            16.dp,
                            onNavigate = {
                                navController.navigate(it.route)
                            }
                        )
                    }
                    composable(Routes.BASIC_SHAPE) {
                        BasicShapeScreen()
                    }
                    composable(Routes.BALL_CLICKER_GAME) {
                        BallClickerGameScreen()
                    }
                    composable(Routes.WEIGHT_PICKER) {
                        WeightPickerScreen()
                    }
                    composable(Routes.CLOCK) {
                        ClockScreen()
                    }
                    composable(Routes.ROULETTE) {
                        RouletteScreen()
                    }
                    composable(Routes.BASIC_PATH) {
                        BasicPathScreen()
                    }
                    composable(Routes.PATH_ANIM) {
                        PathAnimScreen()
                    }
                    composable(Routes.PATH_EFFECT) {
                        PathEffectScreen()
                    }
                    composable(Routes.PATH_DEMONSTRATION) {
                        PathDemonstrationScreen()
                    }
                    composable(Routes.GENDER_PICKER) {
                        GenderPickerScreen()
                    }
                    composable(Routes.TIC_TAC_TOE) {
                        TicTacToeScreen()
                    }
                    composable(Routes.BASIC_IMAGE) {
                        BasicImageScreen()
                    }
                    composable(Routes.IMAGE_REVEAL) {
                        ImageRevealScreen()
                    }
                }
            }
        }
    }
}