package com.android.uas.septiannugraha

import com.google.gson.annotations.SerializedName

data class DataResponse(

    val name: name,

    val flags: flags,
    val coatOfArms: lambang,

    @SerializedName("capital") val capital : List<String> = listOf(),
    val region: String,
    val subregion: String,
    val area: String,
    val population: String,
    @SerializedName("tld") val tld : List<String> = listOf()
)

data class name(
    val official: String,
    val common: String
)

data class flags(
    val svg: String,
    val png: String
)

data class lambang(
    val svg: String,
    val png: String
)