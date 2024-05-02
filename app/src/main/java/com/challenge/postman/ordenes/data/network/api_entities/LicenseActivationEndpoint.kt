package com.challenge.postman.ordenes.data.network.api_entities

import com.google.gson.annotations.SerializedName

data class LicenseActivationRequest(
    val serial: String,
    @SerializedName("device_id") val deviceId: String,
    @SerializedName("device_information") val deviceInformation: String,
    val hostname: String
)

data class LicenseActivationResponse(
    val data: LicenseActivationData
)

data class LicenseActivationData(
    val activation: ActivationInfo
)

data class ActivationInfo(
    @SerializedName("device_id") val deviceId: String,
    @SerializedName("api_key") val apiKey: String,
    val id: String,
    val venue: VenueInfo
)

data class VenueInfo(
    val id: String
)