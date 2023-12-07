package com.brice.reversegeocoding.di

import LoggingInterceptor
import android.util.Log
import android.util.MalformedJsonException
import com.brice.reversegeocoding.repository.GeoKeoRepository
import com.brice.reversegeocoding.service.GeoKeoService
import com.brice.reversegeocoding.viewmodel.ForwardViewModel
import com.brice.reversegeocoding.viewmodel.ReverseViewModel
import okhttp3.OkHttpClient
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

val appModule = module {
    val okHttpClient = OkHttpClient.Builder()
        .addInterceptor(LoggingInterceptor()) // Ajouter l'intercepteur ici
        .build()

    single {
        Retrofit.Builder()
            .baseUrl("https://geokeo.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            .client(okHttpClient)
            .build()
    }


    single { GeoKeoRepository(get()) }
    single { get<Retrofit>().create(GeoKeoService::class.java) }

    viewModel { ReverseViewModel(get()) }
    viewModel { ForwardViewModel(get()) }
}