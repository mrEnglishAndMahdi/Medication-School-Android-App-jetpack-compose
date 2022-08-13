package co.daneshyarwithmahdikhorshidi.medicationschool.network

import co.daneshyarwithmahdikhorshidi.medicationschool.models.dataclassesForNetwork.DrugsNetwork
import co.daneshyarwithmahdikhorshidi.medicationschool.network.DrugApi
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DrugNetworkRepository @Inject constructor(private val drugApi: DrugApi) {
    suspend fun getDrugs(q: String): DrugsNetwork = drugApi.getDrugs(q = q)
}