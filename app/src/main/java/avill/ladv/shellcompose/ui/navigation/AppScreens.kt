package avill.ladv.shellcompose.ui.navigation

sealed class AppScreens(val route:String){
    object SplashScreen: AppScreens("splash_screen")
    object MainScreen: AppScreens("main_screen")
    object MeditateScreen: AppScreens("meditate_screen")
    object ProfileScreen: AppScreens("profile_screen")
    object SleepScreen: AppScreens("sleep_screen")
    object MusicScreen: AppScreens("music_screen")
}
