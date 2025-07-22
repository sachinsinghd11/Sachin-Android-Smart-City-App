package me.sachinsinghdighan.data.remote

import com.google.gson.annotations.SerializedName

data class MiscellaneousDto (
    @SerializedName("id") val id: Int,
    @SerializedName("imageIcon") val imageIcon: Int,
    @SerializedName("title") val title: String,
)