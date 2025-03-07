package com.pnhglobal.data.paging

import androidx.paging.ExperimentalPagingApi
import androidx.paging.LoadType
import androidx.paging.PagingState
import androidx.paging.RemoteMediator
import com.pnhglobal.data.database.entity.store.StoreEntity
import com.pnhglobal.data.datasource.StoreLocalDataSource
import com.pnhglobal.data.datasource.StoreRemoteDataSource
import com.pnhglobal.data.network.model.request.GetStoreListRequest

@OptIn(ExperimentalPagingApi::class)
class StoreListMediator(
    private val remoteDataSource: StoreRemoteDataSource,
    private val localDataSource: StoreLocalDataSource,
    private val request: GetStoreListRequest,
) : RemoteMediator<Int, StoreEntity>() {

    override suspend fun load(
        loadType: LoadType, state: PagingState<Int, StoreEntity>
    ): MediatorResult {
        TODO()
    }
}