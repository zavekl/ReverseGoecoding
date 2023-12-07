package com.brice.reversegeocoding.repository

import com.brice.reversegeocoding.model.LocationResponse
import com.brice.reversegeocoding.service.GeoKeoService
import io.reactivex.rxjava3.core.Observable
import retrofit2.Retrofit
import retrofit2.create

class GeoKeoRepository(private val retrofit: Retrofit) : GeoKeoService {
    override fun searchReverseLocation(
        latitude: Double,
        longitude: Double,
        apiKey: String
    ): Observable<LocationResponse> {
        return retrofit.create(GeoKeoService::class.java)
            .searchReverseLocation(latitude, longitude, apiKey)
    }

    override fun searchForwardLocation(
        address: String,
        apiKey: String
    ): Observable<LocationResponse> {
        return retrofit.create(GeoKeoService::class.java).searchForwardLocation(address, apiKey)
    }
}