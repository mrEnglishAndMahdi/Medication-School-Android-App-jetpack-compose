package co.daneshyarwithmahdikhorshidi.medicationschool.database

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import co.daneshyarwithmahdikhorshidi.medicationschool.models.dataclassesForDB.Drug
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MedicationSchoolDBViewModel @Inject constructor(private val medicationSchoolDBRepository: MedicationSchoolDBRepository) :
    ViewModel() {

    private val _allDrugs = MutableStateFlow<List<Drug>>(emptyList())
    val allDrugs = _allDrugs.asStateFlow()

    private val _allDrugsByFarsiName = MutableStateFlow<List<Drug>>(emptyList())
    val allDrugsByFarsiName = _allDrugsByFarsiName.asStateFlow()

    private val _allDrugsByEnglishName = MutableStateFlow<List<Drug>>(emptyList())
    val allDrugsByEnglishName = _allDrugsByEnglishName.asStateFlow()

    private val _allDrugsByCompanyName = MutableStateFlow<List<Drug>>(emptyList())
    val allDrugsByCompanyName = _allDrugsByCompanyName.asStateFlow()


    init {
        getAllDrugs()
    }

    private fun getAllDrugs(): MutableStateFlow<List<Drug>> {
        viewModelScope.launch {
            medicationSchoolDBRepository.getAllDrugs().distinctUntilChanged().collect { drugList ->
                _allDrugs.value = drugList
            }
        }
        return _allDrugs
    }

    fun getADrugByItsFarsiName(farsiName: String): MutableStateFlow<List<Drug>> {
        viewModelScope.launch {
            medicationSchoolDBRepository.getADrugByItsFarsiName(farsiName).distinctUntilChanged()
                .collect { drugList ->
                    _allDrugsByFarsiName.value = drugList
                }
        }
        return _allDrugsByFarsiName
    }

    fun getADrugByItsEnglishName(englishName: String): MutableStateFlow<List<Drug>> {
        viewModelScope.launch {
            medicationSchoolDBRepository.getADrugByItsEnglishName(englishName).distinctUntilChanged()
                .collect { drugList ->
                    _allDrugsByEnglishName.value = drugList
                }
        }
        return _allDrugsByEnglishName
    }

    fun getADrugByItsCompanyName(companyName: String): MutableStateFlow<List<Drug>> {
        viewModelScope.launch {
            medicationSchoolDBRepository.getADrugByItsCompanyName(companyName).distinctUntilChanged()
                .collect { drugList ->
                    _allDrugsByCompanyName.value = drugList
                }
        }
        return _allDrugsByCompanyName
    }




    fun deleteADrug(drugEntity: Drug) {
        viewModelScope.launch {
            medicationSchoolDBRepository.deleteADrug(drugEntity)
        }
    }

    fun deleteAllDrugs() {
        viewModelScope.launch {
            medicationSchoolDBRepository.deleteAllDrugs()
        }
    }


    fun insertADrug(drugEntity: Drug) {
        viewModelScope.launch {
            medicationSchoolDBRepository.insertADrug(drugEntity)
        }
    }

    fun updateInfoDrug(drugEntity: Drug) {
        viewModelScope.launch {
            medicationSchoolDBRepository.updateInfoDrug(drugEntity)
        }
    }


}
