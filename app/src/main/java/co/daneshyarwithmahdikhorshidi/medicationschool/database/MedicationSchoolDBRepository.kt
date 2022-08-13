package co.daneshyarwithmahdikhorshidi.medicationschool.database

import co.daneshyarwithmahdikhorshidi.medicationschool.models.dataclassesForDB.Drug
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.conflate
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject


class MedicationSchoolDBRepository @Inject constructor(private val medicationSchoolDao: MedicationSchoolDao) {
    fun getAllDrugs(): Flow<List<Drug>> =
        medicationSchoolDao.getAllDrugs().flowOn(Dispatchers.IO).conflate()

    fun getADrugByItsFarsiName(farsiName: String): Flow<List<Drug>> =
        medicationSchoolDao.getADrugByItsFarsiName(farsiName).flowOn(Dispatchers.IO).conflate()

    fun getADrugByItsEnglishName(englishName: String): Flow<List<Drug>> =
        medicationSchoolDao.getADrugByItsEnglishName(englishName).flowOn(Dispatchers.IO).conflate()

    fun getADrugByItsCompanyName(companyName: String): Flow<List<Drug>> =
        medicationSchoolDao.getADrugByItsCompanyName(companyName).flowOn(Dispatchers.IO).conflate()


    suspend fun insertADrug(drugEntity: Drug) = medicationSchoolDao.insertADrug(drugEntity)
    suspend fun deleteADrug(drugEntity: Drug) = medicationSchoolDao.deleteADrug(drugEntity)
    suspend fun deleteAllDrugs() = medicationSchoolDao.deleteAllDrugs()
    suspend fun updateInfoDrug(drugEntity: Drug) = medicationSchoolDao.updateInfoDrug(drugEntity)


}
