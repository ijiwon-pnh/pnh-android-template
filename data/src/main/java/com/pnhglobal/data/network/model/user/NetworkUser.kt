package com.pnhglobal.data.network.model.user

import com.google.gson.annotations.SerializedName

data class NetworkUser(
    @SerializedName("user_id") val userId: Int,
    @SerializedName("user_name") val userName: String? = null,
)