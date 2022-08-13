package co.daneshyarwithmahdikhorshidi.medicationschool.screens.mainScreen

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import co.daneshyarwithmahdikhorshidi.medicationschool.database.MedicationSchoolDBViewModel
import co.daneshyarwithmahdikhorshidi.medicationschool.navigation.BottomNavGraph
import co.daneshyarwithmahdikhorshidi.medicationschool.network.DrugNetworkViewModel
import co.daneshyarwithmahdikhorshidi.medicationschool.utils.customBottomNavBarLayout.BottomNavBar
import co.daneshyarwithmahdikhorshidi.medicationschool.utils.customTopApBarLayout.TopAppBarMainScreen


@Composable
fun MainScreen(
    drugNetworkViewModel: DrugNetworkViewModel,
    medicationSchoolDBViewModel: MedicationSchoolDBViewModel
) {
    val navController = rememberNavController()
    Scaffold(
        topBar = {
            TopAppBarMainScreen()
        },
        bottomBar = {
            BottomNavBar(navController = navController)
        },
        floatingActionButton = {},
    ) {
        BottomNavGraph(
            navController = navController,
            drugNetworkViewModel,
            medicationSchoolDBViewModel
        )
    }


}