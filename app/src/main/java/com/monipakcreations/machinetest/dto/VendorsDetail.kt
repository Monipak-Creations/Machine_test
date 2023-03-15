package com.monipakcreations.machinetest.dto


import com.google.gson.annotations.SerializedName

data class VendorsDetail(
    @SerializedName("address")
    val address: String, // Shading-Protection cars
    @SerializedName("area")
    val area: String, // Abdali
    @SerializedName("areas")
    val areas: List<Area>,
    @SerializedName("avg_rating")
    val avgRating: String, // 5
    @SerializedName("banner")
    val banner: String, // https://admin.t3al.net/uploads/16327423626151abda617608.32410275.jpeg
    @SerializedName("delivery_time")
    val deliveryTime: String, // 0
    @SerializedName("description")
    val description: String, // American type of protection and thermal insulation / 10 years warranty Nano/3 years warranty + front bumper protection without warranty + car pick-up and delivery service from home.
    @SerializedName("destination_id")
    val destinationId: String,
    @SerializedName("end_time")
    val endTime: String, // 21:00:00
    @SerializedName("id")
    val id: String, // 127
    @SerializedName("is_24")
    val is24: String, // 0
    @SerializedName("is_busy")
    val isBusy: String, // 0
    @SerializedName("is_open")
    val isOpen: Int, // 1
    @SerializedName("location")
    val location: String, // 29.0730209,48.1158692
    @SerializedName("logo")
    val logo: String, // https://admin.t3al.net/uploads/162150325260a62d1435ecc7.66590185.jpeg
    @SerializedName("min_order_amount")
    val minOrderAmount: String, // 0
    @SerializedName("name")
    val name: String, // Wrap Art
    @SerializedName("service_charges")
    val serviceCharges: String, // 0
    @SerializedName("start_time")
    val startTime: String, // 09:00:00
    @SerializedName("total_ratings")
    val totalRatings: String, // 1
    @SerializedName("vendor_categories")
    val vendorCategories: List<String>,
    @SerializedName("vendor_policy")
    val vendorPolicy: String, // There is a car pick-up and delivery service
    @SerializedName("working_day")
    val workingDay: String // Tuesday
)