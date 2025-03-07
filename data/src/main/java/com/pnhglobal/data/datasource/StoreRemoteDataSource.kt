package com.pnhglobal.data.datasource

import com.pnhglobal.data.network.model.store.NetworkStore

interface StoreRemoteDataSource {

    suspend fun getStoreDetails(): NetworkStore
}