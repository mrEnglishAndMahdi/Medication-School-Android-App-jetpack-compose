package co.daneshyarwithmahdikhorshidi.medicationschool.network

import co.daneshyarwithmahdikhorshidi.medicationschool.models.constants.nework.NetworkConstants
import co.daneshyarwithmahdikhorshidi.medicationschool.models.dataclassesForNetwork.DrugsNetwork
import retrofit2.http.GET
import retrofit2.http.Query

interface DrugApi {
    @GET(NetworkConstants.PATH)
    suspend fun getDrugs(
        @Query("token") token:String = NetworkConstants.TOKEN,
        @Query("action") action:String = NetworkConstants.ACTION,
        @Query("q") q:String = NetworkConstants.DEFAULT_VALUE
    ): DrugsNetwork

}