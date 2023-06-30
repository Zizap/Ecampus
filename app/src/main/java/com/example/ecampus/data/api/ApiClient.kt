package com.example.ecampus.data.api

import android.util.Log
import com.example.ecampus.constants.Constants
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiClient private constructor() {
    val api:ApiService
        get() = retrofit!!.create(
            ApiService::class.java
        )

    init {
        retrofit = Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build()
        Log.e("Privet","error ApiClient")
    }

    companion object {
        private const val BASE_URL = Constants.BASE_URL
        private var apiClient: ApiClient? = null
        private var retrofit: Retrofit? = null

        val instanse: ApiClient?
            @Synchronized get() {
                if (apiClient == null) {
                    apiClient = ApiClient()
                }
                return apiClient
            }
    }
}