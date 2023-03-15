package com.monipakcreations.machinetest.dto


import com.google.gson.annotations.SerializedName

data class Review(
    @SerializedName("comment")
    val comment: String,
    @SerializedName("rating")
    val rating: Int, // 5
    @SerializedName("title")
    val title: String // Test
)