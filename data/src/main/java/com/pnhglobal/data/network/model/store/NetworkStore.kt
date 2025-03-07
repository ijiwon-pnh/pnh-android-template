package com.pnhglobal.data.network.model.store

import com.google.gson.annotations.SerializedName

data class NetworkStore(
    @SerializedName("store_id") val storeId: Int,
    @SerializedName("store_name") val storeName: String?,
)