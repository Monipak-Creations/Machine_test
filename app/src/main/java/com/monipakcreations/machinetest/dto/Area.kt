package com.monipakcreations.machinetest.dto


import com.google.gson.annotations.SerializedName

data class Area(
    @SerializedName("area_id")
    val areaId: String, // 1
    @SerializedName("latitude")
    val latitude: String, // 	29.12827
    @SerializedName("longitude")
    val longitude: String, // 48.12515
    @SerializedName("name_en")
    val nameEn: String, // Abdulla Port
    @SerializedName("vendor_area_id")
    val vendorAreaId: String // 316733
)