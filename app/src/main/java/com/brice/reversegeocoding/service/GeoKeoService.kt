package com.brice.reversegeocoding.service

import com.brice.reversegeocoding.model.LocationResponse
import io.reactivex.rxjava3.core.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface GeoKeoService {
    @GET("geocode/v1/reverse.php")
    fun searchReverseLocation(
        @Query("lat") latitude: Double,
        @Query("lng") longitude: Double,
        @Query("api") apiKey: String
    ): Observable<LocationResponse>

    @GET("geocode/v1/search.php")
    fun searchForwardLocation(
        @Query("q") address: String,
        @Query("api") apiKey: String
    ): Observable<LocationResponse>
}