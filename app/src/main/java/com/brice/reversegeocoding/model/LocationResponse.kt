package com.brice.reversegeocoding.model

data class LocationResponse(
    val results: List<LocationResult>?,
    val credits: String?,
    val status: String?
)
