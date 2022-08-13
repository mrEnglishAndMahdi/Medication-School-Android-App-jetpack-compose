package co.daneshyarwithmahdikhorshidi.medicationschool.database

import androidx.room.*
import co.daneshyarwithmahdikhorshidi.medicationschool.models.dataclassesForDB.Drug
import kotlinx.coroutines.flow.Flow

@Dao
interface MedicationSchoolDao {

    @Query("SELECT * FROM drug_table_db ORDER BY id ASC")
    fun getAllDrugs(): Flow<List<Drug>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertADrug(drug: Drug)

    @Delete
    suspend fun deleteADrug(drugEntity: Drug)

    @Query("DELETE FROM drug_table_db")
    suspend fun deleteAllDrugs()

    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun updateInfoDrug(drugEntity: Drug)


    @Query("SELECT * FROM drug_table_db WHERE faname LIKE :farsiName")
    fun getADrugByItsFarsiName(farsiName:String): Flow<List<Drug>>

    @Query("SELECT * FROM drug_table_db WHERE enname LIKE :englishName")
    fun getADrugByItsEnglishName(englishName:String): Flow<List<Drug>>

    @Query("SELECT * FROM drug_table_db WHERE company LIKE :companyName")
    fun getADrugByItsCompanyName(companyName:String): Flow<List<Drug>>





}
