package com.monipakcreations.machinetest.dto


import com.google.gson.annotations.SerializedName

data class VendorsItem(
    @SerializedName("items")
    val items: List<Item>,
    @SerializedName("vendor_category_id")
    val vendorCategoryId: Int, // 381
    @SerializedName("vendor_category_name")
    val vendorCategoryName: String // Heat rejection / Tinting
)