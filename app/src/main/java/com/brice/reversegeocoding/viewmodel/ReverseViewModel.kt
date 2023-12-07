package com.brice.reversegeocoding.viewmodel

import androidx.lifecycle.ViewModel
import com.brice.reversegeocoding.model.LocationResponse
import com.brice.reversegeocoding.repository.GeoKeoRepository
import io.reactivex.rxjava3.core.Observable

class ReverseViewModel(private val geoKeoRepository: GeoKeoRepository) : ViewModel() {
    fun searchReverseLocation(latitude: Double, longitude: Double, apiKey: String): Observable<LocationResponse> {
        return geoKeoRepository.searchReverseLocation(latitude, longitude, apiKey)
    }
}