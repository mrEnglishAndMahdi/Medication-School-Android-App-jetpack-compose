package co.daneshyarwithmahdikhorshidi.medicationschool.models.constants.bottomNavBar

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.History
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.ui.graphics.vector.ImageVector
import co.daneshyarwithmahdikhorshidi.medicationschool.models.constants.screenNames.Screens

sealed class BottomBarScreen(
    val route: String,
    val title:String,
    val icon: ImageVector
    ){
    object Home:BottomBarScreen(
        route = Screens.HomeScreen.name,
        title = " خانه",
        icon = Icons.Default.Home
    )

    object  SearchHistory:BottomBarScreen(
        route = Screens.SearchHistoryScreen.name,
        title = "تاریخچه جستجو",
        icon = Icons.Default.History
    )

    object AboutUs:BottomBarScreen(
        route = Screens.AboutUsScreen.name,
        title = " درباره ما",
        icon = Icons.Default.Info
    )
}