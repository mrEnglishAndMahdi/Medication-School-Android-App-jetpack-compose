package co.daneshyarwithmahdikhorshidi.medicationschool.network

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import co.daneshyarwithmahdikhorshidi.medicationschool.models.dataclassesForDB.Drug
import co.daneshyarwithmahdikhorshidi.medicationschool.models.dataclassesForNetwork.DrugsNetwork
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DrugNetworkViewModel @Inject constructor(private val drugNetworkRepository: DrugNetworkRepository) :
    ViewModel() {

    private val _getTheSearchedDrugs: MutableState<DrugsNetwork> = mutableStateOf(
        DrugsNetwork(status = 200, result = listOf())
    )



    fun getTheSearchedDrug(item: String):DrugsNetwork {
        viewModelScope.launch {
            _getTheSearchedDrugs.value = drugNetworkRepository.getDrugs(q = item)
        }
        return _getTheSearchedDrugs.value
    }


}