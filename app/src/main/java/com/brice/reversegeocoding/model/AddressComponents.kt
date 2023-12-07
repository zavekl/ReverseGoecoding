package com.brice.reversegeocoding.model

data class AddressComponents(
    val name: String?,
    val island: String?,
    val street: String?,
    val neighbourhood: String?,
    val subdistrict: String?,
    val district: String?,
    val city: String?,
    val state: String?,
    val postcode: String?,
    val country: String?
)
