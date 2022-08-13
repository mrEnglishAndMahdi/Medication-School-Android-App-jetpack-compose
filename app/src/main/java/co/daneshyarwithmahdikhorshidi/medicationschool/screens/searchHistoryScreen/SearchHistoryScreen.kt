package co.daneshyarwithmahdikhorshidi.medicationschool.screens.searchHistoryScreen

import android.util.Log
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import co.daneshyarwithmahdikhorshidi.medicationschool.R
import co.daneshyarwithmahdikhorshidi.medicationschool.database.MedicationSchoolDBViewModel
import co.daneshyarwithmahdikhorshidi.medicationschool.models.dataclassesForDB.Drug
import co.daneshyarwithmahdikhorshidi.medicationschool.utils.itemCardShower.ItemCardShowerForSearchHistoryScreen


@Composable
fun SearchHistoryScreen(
    medicationSchoolDBViewModel: MedicationSchoolDBViewModel,
) {
    val drug = medicationSchoolDBViewModel.allDrugs.collectAsState().value

    val expandInformation = remember {
        mutableStateOf(false)
    }
MainContentForSearchHistoryScreen(searchADrug = drug, expand = expandInformation,
medicationSchoolDBViewModel = medicationSchoolDBViewModel
    )

}



@Composable
private fun MainContentForSearchHistoryScreen(
    searchADrug: List<Drug>,
    expand:MutableState<Boolean>,
    medicationSchoolDBViewModel: MedicationSchoolDBViewModel
) {

    Surface(modifier = Modifier.fillMaxSize(), color = Color.White) {
        Column(
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            if (searchADrug.isEmpty()) {
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
                        modifier = Modifier
                            .weight(2f)
                            .padding(10.dp),
                        text = "مشاهده تمام داروهایی ذخیره شده \n!!! هنوز دارویی ذخیره نشده است",
                        fontFamily = FontFamily.Serif,
                        fontWeight = FontWeight.Bold,
                        color = Color.Gray.copy(0.5f),
                    )
                }
            }
            AnimatedVisibility(visible = searchADrug.isNotEmpty()) {
                LazyColumn{
                    items(searchADrug) { drug ->
                        ItemCardShowerForSearchHistoryScreen(drug = drug, expand = expand, onDeleteClicked = {drugItem->
                            medicationSchoolDBViewModel.deleteADrug(drugEntity = drugItem)
                        }, onShareClicked = {drugItem->
                            Log.d("Share", "MainContentForSearchHistoryScreen: $drugItem")
                        })
                    }
                }
            }
        }
    }
}

