package co.daneshyarwithmahdikhorshidi.medicationschool.di

import android.content.Context
import androidx.room.Room
import co.daneshyarwithmahdikhorshidi.medicationschool.database.MedicationSchoolDB
import co.daneshyarwithmahdikhorshidi.medicationschool.database.MedicationSchoolDao
import co.daneshyarwithmahdikhorshidi.medicationschool.models.constants.database.DatabaseConstants
import co.daneshyarwithmahdikhorshidi.medicationschool.models.constants.nework.NetworkConstants
import co.daneshyarwithmahdikhorshidi.medicationschool.network.DrugApi
import co.daneshyarwithmahdikhorshidi.medicationschool.network.DrugNetworkRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class MedicationSchoolModule {


    @Provides
    @Singleton
    fun provideDrugDb(@ApplicationContext context: Context): MedicationSchoolDB =
        Room.databaseBuilder(
            context,
            MedicationSchoolDB::class.java,
            DatabaseConstants.DATABASE_NAME
        ).fallbackToDestructiveMigration().build()

    @Provides
    @Singleton
    fun provideDrugDbDao(medicationSchoolDB: MedicationSchoolDB): MedicationSchoolDao =
        medicationSchoolDB.medicationSchoolDao()

    @Singleton
    @Provides
    fun provideDrugNetworkRepository(api: DrugApi)
            = DrugNetworkRepository(api)


    @Singleton
    @Provides
    fun provideDrugApiNetwork():DrugApi{
        return Retrofit.Builder()
            .baseUrl(NetworkConstants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(DrugApi::class.java)
    }


}