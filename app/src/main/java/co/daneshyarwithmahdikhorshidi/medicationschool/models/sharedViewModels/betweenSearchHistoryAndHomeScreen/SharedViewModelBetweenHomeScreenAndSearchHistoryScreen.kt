package co.daneshyarwithmahdikhorshidi.medicationschool.models.sharedViewModels.betweenSearchHistoryAndHomeScreen

import androidx.lifecycle.ViewModel
import co.daneshyarwithmahdikhorshidi.medicationschool.models.dataclassesForDB.Drug

class SharedViewModelBetweenHomeScreenAndSearchHistoryScreen :ViewModel() {
    private var drug:Drug = Drug(id = 1,null,null,null,null,
        null,null,null,null,null,null,null,
        null,null,null
        )

    fun getTheDrug(clickedDrug:Drug){
        drug = clickedDrug
    }




}