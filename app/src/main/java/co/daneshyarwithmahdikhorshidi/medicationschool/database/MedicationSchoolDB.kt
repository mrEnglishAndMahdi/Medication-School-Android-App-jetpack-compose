package co.daneshyarwithmahdikhorshidi.medicationschool.database

import androidx.room.Database
import androidx.room.RoomDatabase
import co.daneshyarwithmahdikhorshidi.medicationschool.models.dataclassesForDB.Drug

@Database(entities = [Drug::class], version = 1, exportSchema = false)
abstract class MedicationSchoolDB :RoomDatabase() {
    abstract fun medicationSchoolDao():MedicationSchoolDao
}