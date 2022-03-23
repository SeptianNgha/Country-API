package com.android.uas.septiannugraha.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object CountryClient {

    private const val BASE_URL = "https://restcountries.com/v3.1/"
    val instance: CountryApi by lazy {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        retrofit.create(CountryApi::class.java)
    }
}