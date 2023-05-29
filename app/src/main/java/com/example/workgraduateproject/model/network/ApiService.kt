package com.example.myapplication.network

import com.example.workgraduateproject.model.AllWorks
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET



interface ApiService {
    @GET("all/works")
    suspend fun getAllWorkData(): AllWorks
//
//    @GET("all/works")
//    suspend fun getCompleteOrder(): AllWorks
//
//
//    @GET("all/works")
//    suspend fun getPendingOrder(): AllWorks


    companion object {
        var apiService: ApiService? = null
        fun getInstance(): ApiService {
            if (apiService == null) {
                apiService = Retrofit.Builder()
                    .baseUrl("https://studentucas.awamr.com/api/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build().create(ApiService::class.java)
            }
            return apiService!!
        }
    }


}

