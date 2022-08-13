package co.daneshyarwithmahdikhorshidi.medicationschool.utils.customBottomNavBarLayout

import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import co.daneshyarwithmahdikhorshidi.medicationschool.R
import co.daneshyarwithmahdikhorshidi.medicationschool.models.constants.bottomNavBar.BottomBarScreen

@Composable
fun BottomNavBar(navController: NavHostController) {
    val screens = listOf(
        BottomBarScreen.Home,
        BottomBarScreen.SearchHistory,
        BottomBarScreen.AboutUs
    )

    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination
    BottomNavigation(backgroundColor = colorResource(id = R.color.MediumColor),
        contentColor = Color.White) {
        screens.forEach { screen ->
            AddItem(
                screen = screen,
                navController = navController,
                currentDestination = currentDestination
            )
        }
    }

}


@Composable
fun RowScope.AddItem(
    screen: BottomBarScreen,
    navController: NavHostController,
    currentDestination: NavDestination?,
) {

    BottomNavigationItem(
        icon = {
            Icon(
                imageVector = screen.icon,
                contentDescription = screen.title
            )
        },
        label = {
            Text(text = screen.title)
        },
        unselectedContentColor = LocalContentColor.current.copy(alpha = ContentAlpha.disabled),
        selected = currentDestination?.hierarchy?.any {
            it.route == screen.route
        } == true,
        onClick = {
            navController.navigate(screen.route) {
                popUpTo(navController.graph.findStartDestination().id)
                launchSingleTop = true
            }
        }
    )
}


