package com.monipakcreations.machinetest.dto


import com.google.gson.annotations.SerializedName

data class SubItem(
    @SerializedName("addon_values")
    val addonValues: List<AddonValue>,
    @SerializedName("id")
    val id: Int, // 2611
    @SerializedName("maximum")
    val maximum: Int, // 1
    @SerializedName("minimum")
    val minimum: Int, // 0
    @SerializedName("name")
    val name: String // Add ONs	
)