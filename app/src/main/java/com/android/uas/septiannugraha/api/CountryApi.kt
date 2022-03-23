package com.android.uas.septiannugraha.api

import com.android.uas.septiannugraha.DataResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface CountryApi {

    @GET("all")
    fun getPosts(): Call<ArrayList<DataResponse>>

    @GET("{searchBy}/{valueBy}")
    fun getSearch(
        @Path("searchBy") searchBy: String,
        @Path("valueBy") valueBy: String): Call<ArrayList<DataResponse>>
}