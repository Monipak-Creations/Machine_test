package com.monipakcreations.machinetest.dto

import com.google.gson.annotations.SerializedName


data class AddonValue(
    @SerializedName("discount_price")
    val discountPrice: Int, // 0
    @SerializedName("id")
    val id: Int, // 4640
    @SerializedName("name")
    val name: String, // Sunroof
    @SerializedName("price")
    val price: Double // 7.5
)