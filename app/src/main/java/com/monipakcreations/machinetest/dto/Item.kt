package com.monipakcreations.machinetest.dto


import com.google.gson.annotations.SerializedName

data class Item(
    @SerializedName("description")
    val description: String, // Heat rejection up to 90% depends on your choice of colors All windows 
    @SerializedName("duration")
    val duration: String, // 2
    @SerializedName("icon")
    val icon: String, // https://admin.t3al.net/uploads/16309262626135f5b6896529.24319640.jpg
    @SerializedName("id")
    val id: Int, // 4290
    @SerializedName("is_busy")
    val isBusy: Int, // 0
    @SerializedName("is_product")
    val isProduct: Int, // 0
    @SerializedName("name")
    val name: String, // Heat rejection / Window tint ( Saloon )
    @SerializedName("quantity")
    val quantity: Int, // 0
    @SerializedName("regular_price")
    val regularPrice: Int, // 110
    @SerializedName("service_discount_price")
    val serviceDiscountPrice: Any?, // null
    @SerializedName("service_price")
    val servicePrice: Double, // 59.5
    @SerializedName("sub_item")
    val subItem: List<SubItem>,
    @SerializedName("vendor_id")
    val vendorId: String, // 127
    @SerializedName("working_days")
    val workingDays: List<WorkingDay>
)