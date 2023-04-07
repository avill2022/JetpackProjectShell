package avill.ladv.shellcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import avill.ladv.shellcompose.ui.AppScreens
import avill.ladv.shellcompose.ui.MainScreen
import avill.ladv.shellcompose.ui.SplashScreen
import avill.ladv.shellcompose.ui.theme.ShellComposeTheme

class MainActivity : ComponentActivity() {
    @ExperimentalFoundationApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ShellComposeTheme {
                Navigation()
            }
        }
    }
}

@ExperimentalFoundationApi
@Composable
fun Navigation(){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = AppScreens.SplashScreen.route ){
        composable(AppScreens.SplashScreen.route){
            SplashScreen(navController = navController)
        }
        composable(AppScreens.MainScreen.route){
            MainScreen()
        }
    }
}