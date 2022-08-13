package co.daneshyarwithmahdikhorshidi.medicationschool.internetConnectivity

sealed class ConnectionState{
    object Available : ConnectionState()
    object Unavailable : ConnectionState()
}