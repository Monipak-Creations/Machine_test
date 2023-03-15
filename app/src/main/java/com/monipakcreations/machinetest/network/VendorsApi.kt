package com.monipakcreations.machinetest.network

import com.monipakcreations.machinetest.dto.Data
import com.monipakcreations.machinetest.dto.VendorDetails
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface VendorsApi {
    @GET("vendor-details")
    suspend fun getVendorsList(
        @Query("id") id: String,
        @Query("lang") lang: String,
        @Query("user_id") userID: String,
    ): Response<VendorDetails>
}