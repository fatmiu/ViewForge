package com.miumiu.viewforge

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.miumiu.viewforge.ui.canvas_basic.BasicShapeScreen
import com.miumiu.viewforge.ui.canvas_basic.ball_clicker_game.BallClickerScreen
import com.miumiu.viewforge.ui.forge.ForgeScreen
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
                            onNavigate = {
                                navController.navigate(it.route)
                            }
                        )
                    }
                    composable(Routes.BASIC_SHAPE) {
                        BasicShapeScreen()
                    }
                    composable(Routes.BALL_CLICKER_GAME) {
                        BallClickerScreen()
                    }
                }
            }
        }
    }
}