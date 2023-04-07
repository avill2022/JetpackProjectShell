package avill.ladv.shellcompose.ui.navigation

import androidx.annotation.DrawableRes
import androidx.compose.ui.graphics.Color

data class TopNavigationItem(
    val title: String,
    @DrawableRes val iconId: Int,
    val lightColor: Color,
    val mediumColor: Color,
    val darkColor: Color
)
