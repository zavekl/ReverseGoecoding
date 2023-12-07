package com.brice.reversegeocoding.viewmodel

import androidx.lifecycle.ViewModel
import com.brice.reversegeocoding.model.LocationResponse
import com.brice.reversegeocoding.repository.GeoKeoRepository
import io.reactivex.rxjava3.core.Observable

class ForwardViewModel(private val geoKeoRepository: GeoKeoRepository) : ViewModel() {
    fun searchForwardLocation(address: String, apiKey: String): Observable<LocationResponse> {
        return geoKeoRepository.searchForwardLocation(address, apiKey)
    }
}