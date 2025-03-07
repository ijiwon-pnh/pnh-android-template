package com.pnhglobal.data.network.service

import com.pnhglobal.data.network.model.store.NetworkStore
import retrofit2.http.GET
import retrofit2.http.POST

interface StoreService {
    companion object {
        private const val API_ROUTE = "store/"

        private const val GET_STORE_LIST = "getStoreList"
        private const val GET_STORE_DETAIL = "getStoreDetail"
    }

    @GET("$API_ROUTE$GET_STORE_LIST")
    suspend fun getStoreList(): List<NetworkStore>

    @POST("$API_ROUTE$GET_STORE_DETAIL")
    suspend fun getStoreDetail(): NetworkStore
}