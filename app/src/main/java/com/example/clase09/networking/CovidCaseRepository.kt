package com.example.clase09.networking

import com.example.clase09.model.CovidCaseModel
import retrofit2.Call
import retrofit2.http.GET

interface CovidCaseRepository {

    @GET("countries?yesterday")
    fun getCountriesCovidCases(): Call<List<CovidCaseModel>>
}