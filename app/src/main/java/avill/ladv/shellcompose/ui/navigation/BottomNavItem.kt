package avill.ladv.shellcompose.ui.navigation

import androidx.annotation.DrawableRes

data class BottomNavItem(
    val title: String,
    val route:String,
    @DrawableRes val iconId: Int,
    val badgeCount: Int = 0
)
