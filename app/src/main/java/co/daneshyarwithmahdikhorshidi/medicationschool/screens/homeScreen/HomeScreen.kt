@file:Suppress("DEPRECATED_IDENTITY_EQUALS")

package co.daneshyarwithmahdikhorshidi.medicationschool.screens.homeScreen

import android.content.Context
import android.widget.Toast
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import co.daneshyarwithmahdikhorshidi.medicationschool.R
import co.daneshyarwithmahdikhorshidi.medicationschool.database.MedicationSchoolDBViewModel
import co.daneshyarwithmahdikhorshidi.medicationschool.internetConnectivity.ConnectionState
import co.daneshyarwithmahdikhorshidi.medicationschool.internetConnectivity.connectivityState
import co.daneshyarwithmahdikhorshidi.medicationschool.models.dataclassesForDB.Drug
import co.daneshyarwithmahdikhorshidi.medicationschool.network.DrugNetworkViewModel
import co.daneshyarwithmahdikhorshidi.medicationschool.utils.customInputLayout.CustomInputLayout
import co.daneshyarwithmahdikhorshidi.medicationschool.utils.itemCardShower.CardItemShowerForDB
import kotlinx.coroutines.ExperimentalCoroutinesApi


@OptIn(ExperimentalCoroutinesApi::class)
@Composable
fun HomeScreen(
    navController: NavHostController,
    drugNetworkViewModel: DrugNetworkViewModel,
    medicationSchoolDBViewModel: MedicationSchoolDBViewModel
) {
    // This will cause re-composition on every network state change
    val connection by connectivityState()
    val isConnected = connection === ConnectionState.Available
    if (isConnected) {
        // Show UI when connectivity is available
        ShowUI(drugNetworkViewModel, medicationSchoolDBViewModel)
    } else {
        Surface(modifier = Modifier.fillMaxSize(), color = Color.White) {
            Column(verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
                Text(modifier = Modifier.padding(10.dp),
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight.Bold,
                    color = Color.Red,
                    fontFamily = FontFamily.Serif,
                    text = "شما افلاین هستید اینترنت خود را روشن کنید برای جستجو")
            }
        }
    }




}

@Composable
private fun ShowUI(
    drugNetworkViewModel: DrugNetworkViewModel,
    medicationSchoolDBViewModel: MedicationSchoolDBViewModel
) {
    val text = remember {
        mutableStateOf("")
    }
    val searchedDrugText = remember {
        mutableStateOf("سرماخوردگی")
    }

    val context = LocalContext.current
    val searchADrug = drugNetworkViewModel.getTheSearchedDrug(item = searchedDrugText.value)


    if (searchADrug.status !== 200) {
        Toast.makeText(context, "داروی مورد نظر یافت نشد", Toast.LENGTH_SHORT).show()
        text.value = ""
        searchedDrugText.value = "سرماخوردگی"
    } else {
        MainContent(
            searchADrug = searchADrug.result, drugDbViewModel = medicationSchoolDBViewModel,
            context = context, text = text, getTheValue = { drug ->
                searchedDrugText.value = drug
            }
        )
    }
}


@Composable
private fun MainContent(
    searchADrug: List<Drug>,
    drugDbViewModel: MedicationSchoolDBViewModel,
    context: Context,
    text: MutableState<String>,
    getTheValue: (String) -> Unit = {}
) {

    Surface(modifier = Modifier.fillMaxSize(), color = Color.White) {
        Column(
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxSize()
        ) {
            CustomInputLayout(onValueChanged = {
                getTheValue(it)
            }, text = text)
            if (text.value.isEmpty()) {
                Column(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Image(
                        modifier = Modifier
                            .weight(5f)
                            .fillMaxSize(),
                        painter = painterResource(id = R.drawable.background),
                        contentDescription = "background"
                    )
                    Text(
                        modifier = Modifier.weight(1f),
                        text = "جستجو اطلاعات میان بیش از 15 هزار دارو",
                        fontFamily = FontFamily.Serif,
                        fontWeight = FontWeight.Bold,
                        color = Color.Gray.copy(0.5f),
                    )

                }
            }
            AnimatedVisibility(visible = text.value.isNotEmpty()) {
                    LazyColumn {
                        items(searchADrug) { drug ->
                            CardItemShowerForDB(drug = drug) {
                                drugDbViewModel.insertADrug(drug)
                                Toast.makeText(
                                    context,
                                    "دارو به لیست جستجو شده ها اضافه شد",
                                    Toast.LENGTH_SHORT
                                ).show()
                            }
                        }
                    }
            }
        }
    }
}


