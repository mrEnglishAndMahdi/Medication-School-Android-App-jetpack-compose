package co.daneshyarwithmahdikhorshidi.medicationschool.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import co.daneshyarwithmahdikhorshidi.medicationschool.database.MedicationSchoolDBViewModel
import co.daneshyarwithmahdikhorshidi.medicationschool.models.constants.screenNames.Screens
import co.daneshyarwithmahdikhorshidi.medicationschool.network.DrugNetworkViewModel
import co.daneshyarwithmahdikhorshidi.medicationschool.screens.aboutUsScreen.AboutUsScreen
import co.daneshyarwithmahdikhorshidi.medicationschool.screens.homeScreen.HomeScreen
import co.daneshyarwithmahdikhorshidi.medicationschool.screens.mainScreen.MainScreen
import co.daneshyarwithmahdikhorshidi.medicationschool.screens.searchHistoryScreen.SearchHistoryScreen
import co.daneshyarwithmahdikhorshidi.medicationschool.screens.splashScreen.SplashScreen
import co.daneshyarwithmahdikhorshidi.medicationschool.screens.structralSplashScreen.StructuralSplashScreen

@Composable
fun BottomNavGraph(
    navController: NavHostController,
    drugNetworkViewModel: DrugNetworkViewModel,
    medicationSchoolDBViewModel: MedicationSchoolDBViewModel
) {
    NavHost(
        navController = navController,
        startDestination = Screens.HomeScreen.name
    ) {
        composable(route = Screens.MainScreen.name) {
            MainScreen(
                drugNetworkViewModel = drugNetworkViewModel,
                medicationSchoolDBViewModel = medicationSchoolDBViewModel
            )
        }
        composable(route = Screens.SearchHistoryScreen.name) {
            SearchHistoryScreen(
                medicationSchoolDBViewModel = medicationSchoolDBViewModel
            )
        }

        composable(route = Screens.HomeScreen.name) {
            HomeScreen(
                navController = navController,
                drugNetworkViewModel = drugNetworkViewModel,
                medicationSchoolDBViewModel = medicationSchoolDBViewModel
            )
        }
        composable(route = Screens.AboutUsScreen.name) {
            AboutUsScreen()
        }
        composable(route = Screens.SplashScreen.name) {
            SplashScreen(
                navController = navController
            )
        }

        composable(route = Screens.StructuralSplashScreen.name) {
            StructuralSplashScreen(
                navController = navController
            )
        }


    }

}