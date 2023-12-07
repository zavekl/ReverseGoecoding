package com.brice.reversegeocoding.model

import com.google.gson.annotations.SerializedName

data class LocationResult(
    @SerializedName("class")
    val classType: String?,
    val type: String?,
    @SerializedName("address_components")
    val addressComponents: AddressComponents?,
    @SerializedName("formatted_address")
    val formattedAddress: String?,
    val geometry: Geometry?,
    val osmUrl: String?,
    val distance: String?,
    val importance: String?
)