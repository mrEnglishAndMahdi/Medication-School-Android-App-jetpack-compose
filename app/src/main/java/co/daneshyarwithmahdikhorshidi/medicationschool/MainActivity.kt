package co.daneshyarwithmahdikhorshidi.medicationschool

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.runtime.Composable
import co.daneshyarwithmahdikhorshidi.medicationschool.database.MedicationSchoolDBViewModel
import co.daneshyarwithmahdikhorshidi.medicationschool.internetConnectivity.ConnectionState
import co.daneshyarwithmahdikhorshidi.medicationschool.internetConnectivity.connectivityState
import co.daneshyarwithmahdikhorshidi.medicationschool.network.DrugNetworkViewModel
import co.daneshyarwithmahdikhorshidi.medicationschool.screens.mainScreen.MainScreen
import co.daneshyarwithmahdikhorshidi.medicationschool.ui.theme.MedicationSchoolTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.ExperimentalCoroutinesApi

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val medicationSchoolDBViewModel by viewModels<MedicationSchoolDBViewModel>()
            val drugNetworkViewModel by viewModels<DrugNetworkViewModel>()
            MedicationSchoolTheme(darkTheme = false) {
                MainScreen(drugNetworkViewModel, medicationSchoolDBViewModel)
            }
        }
    }
}

