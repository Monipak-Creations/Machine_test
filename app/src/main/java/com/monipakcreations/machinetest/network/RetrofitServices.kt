package com.monipakcreations.machinetest.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitServices {
    private val BASE_URL = "https://admin.t3al.net/api/v2/";
    fun getVendorsAPIService(): VendorsApi{
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(VendorsApi::class.java)
    }
}