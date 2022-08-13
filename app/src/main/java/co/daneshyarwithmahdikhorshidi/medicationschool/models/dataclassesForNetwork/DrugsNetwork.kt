package co.daneshyarwithmahdikhorshidi.medicationschool.models.dataclassesForNetwork

import co.daneshyarwithmahdikhorshidi.medicationschool.models.dataclassesForDB.Drug


data class DrugsNetwork(
    val status:Int,
    val result:List<Drug>
)
