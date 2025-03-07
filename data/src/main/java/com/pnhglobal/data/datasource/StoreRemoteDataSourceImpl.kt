package com.pnhglobal.data.datasource

import com.pnhglobal.data.network.model.store.NetworkStore
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class StoreRemoteDataSourceImpl @Inject constructor() : StoreRemoteDataSource {

    override suspend fun getStoreDetails(): NetworkStore {
        TODO("Not yet implemented")
    }
}