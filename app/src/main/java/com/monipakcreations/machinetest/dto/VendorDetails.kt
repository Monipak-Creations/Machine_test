package com.monipakcreations.machinetest.dto


import com.google.gson.annotations.SerializedName

data class VendorDetails(
    @SerializedName("data")
    val `data`: Data,
    @SerializedName("message")
    val message: String,
    @SerializedName("status")
    val status: Int, // 200
    @SerializedName("success")
    val success: Boolean // true
)