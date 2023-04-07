package avill.ladv.shellcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.BottomNavigation
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import avill.ladv.shellcompose.ui.navigation.AppScreens
import avill.ladv.shellcompose.ui.navigation.BottomNavItem
import avill.ladv.shellcompose.ui.screens.*
import avill.ladv.shellcompose.ui.theme.AquaBlue
import avill.ladv.shellcompose.ui.theme.ButtonBlue
import avill.ladv.shellcompose.ui.theme.DeepBlue
import avill.ladv.shellcompose.ui.theme.ShellComposeTheme

class MainActivity : ComponentActivity() {
    @ExperimentalFoundationApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ShellComposeTheme {
                NavigationSplashScreen()
            }
        }
    }
}

@ExperimentalFoundationApi
@Composable
fun NavigationSplashScreen(){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = AppScreens.SplashScreen.route ){
        composable(AppScreens.SplashScreen.route){
            SplashScreen(navController = navController)
        }
        composable(AppScreens.MainScreen.route){
            val navControllerBottom = rememberNavController()
            Scaffold(bottomBar = {
                BottomNavigationBar(
                    items = listOf(
                        BottomNavItem("Home", AppScreens.MainScreen.route, R.drawable.ic_home, 0),//object asosiate
                        BottomNavItem("Meditate", AppScreens.MeditateScreen.route, R.drawable.ic_bubble,0),
                        BottomNavItem("Sleep", AppScreens.SleepScreen.route, R.drawable.ic_moon,0),
                        BottomNavItem("Music", AppScreens.MusicScreen.route, R.drawable.ic_music,0),
                        BottomNavItem("Profile", AppScreens.ProfileScreen.route, R.drawable.ic_profile,0)
                    ),
                    navController = navControllerBottom,
                    onItemClick ={
                        navControllerBottom.navigate(it.route)
                    }
                )
            }){
                NavigationBottomMenu(navController = navControllerBottom)
            }
        }
    }
}

@Composable
fun BottomNavigationBar(
    items: List<BottomNavItem>,
    navController: NavController,
    modifier: Modifier = Modifier,
    onItemClick:(BottomNavItem)->Unit,
    activeHighlightColor: Color = ButtonBlue,
    activeTextColor: Color = Color.White,
    inactiveTextColor: Color = AquaBlue
) {
    val backStackEntry = navController.currentBackStackEntryAsState()
    BottomNavigation (
        modifier = modifier
            .fillMaxWidth()
            .background(DeepBlue)
            ,elevation = 5.dp
    ){
        items.forEach { item ->
            val selected = item.route == backStackEntry.value?.destination?.route
            BottomNavigationItem(
                item = item,
                isSelected = selected,
                activeHighlightColor = activeHighlightColor,
                activeTextColor = activeTextColor,
                inactiveTextColor = inactiveTextColor,
                onItemClick = {
                    onItemClick(item)
                }
            )
        }
    }
}

@Composable
fun BottomNavigationItem(
    item: BottomNavItem,
    isSelected: Boolean = false,//default values
    activeHighlightColor: Color = ButtonBlue,//default values
    activeTextColor: Color = Color.White,
    inactiveTextColor: Color = AquaBlue,
    onItemClick: (BottomNavItem) -> Unit
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.clickable {
            onItemClick(item)
        }
    ) {
        if(item.badgeCount>0){
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .clip(RoundedCornerShape(10.dp))
                    .background(if (isSelected) activeHighlightColor else Color.Transparent)
                    .padding(10.dp)
            ) {
                Icon(
                    painter = painterResource(id = item.iconId),
                    contentDescription = item.title,
                    tint = if (isSelected) activeTextColor else inactiveTextColor,
                    modifier = Modifier.size(20.dp)
                )
            }
        }else{
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .clip(RoundedCornerShape(10.dp))
                    .background(if (isSelected) activeHighlightColor else Color.Transparent)
                    .padding(10.dp)
            ) {
                Icon(
                    painter = painterResource(id = item.iconId),
                    contentDescription = item.title,
                    tint = if (isSelected) activeTextColor else inactiveTextColor,
                    modifier = Modifier.size(20.dp)
                )
            }
        }
        Text(
            text = item.title,
            color = if (isSelected) activeTextColor else inactiveTextColor
        )
    }
}


@ExperimentalFoundationApi
@Composable
fun NavigationBottomMenu(navController: NavHostController){
    NavHost(navController = navController, startDestination = AppScreens.MainScreen.route ){
        composable(AppScreens.MainScreen.route){
            MainScreen()
        }
        composable(AppScreens.MeditateScreen.route){
            MeditateScreen()
        }
        composable(AppScreens.MusicScreen.route){
            MusicScreen()
        }
        composable(AppScreens.SleepScreen.route){
            SleepScreen()
        }
        composable(AppScreens.ProfileScreen.route){
            ProfileScreen()
        }
    }
}

@Preview(showBackground = true)
@ExperimentalFoundationApi
@Composable
fun HomeScreenPreview(){
    MainScreen()
}