package com.monipakcreations.machinetest.dto


import com.google.gson.annotations.SerializedName

data class WorkingDay(
    @SerializedName("end_time")
    val endTime: String, // 21:00:00
    @SerializedName("is_24")
    val is24: Int, // 0
    @SerializedName("start_time")
    val startTime: String, // 09:00:00
    @SerializedName("working_day")
    val workingDay: String // Sunday
)