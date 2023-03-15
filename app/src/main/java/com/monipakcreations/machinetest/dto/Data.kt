package com.monipakcreations.machinetest.dto


import com.google.gson.annotations.SerializedName

data class Data(
    @SerializedName("Reviews")
    val reviews: List<Review>,
    @SerializedName("User_loyalty_points")
    val userLoyaltyPoints: Int, // 0
    @SerializedName("Vendors_detail")
    val vendorsDetail: VendorsDetail,
    @SerializedName("Vendors_items")
    val vendorsItems: List<VendorsItem>
)