package com.pnhglobal.data.repository

import androidx.paging.ExperimentalPagingApi
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.map
import com.pnhglobal.data.datasource.StoreLocalDataSource
import com.pnhglobal.data.datasource.StoreRemoteDataSource
import com.pnhglobal.data.network.model.request.GetStoreListRequest
import com.pnhglobal.data.paging.StoreListMediator
import com.pnhglobal.data.utils.toDomain
import com.pnhglobal.domain.model.store.Store
import com.pnhglobal.domain.repository.StoreRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class StoreRepositoryImpl @Inject constructor(
    private val remoteDataSource: StoreRemoteDataSource,
    private val localDataSource: StoreLocalDataSource,
) : StoreRepository {

    @OptIn(ExperimentalPagingApi::class)
    override fun getNearbyStores(
        sort: Int?,
        searchText: String?,
    ): Flow<PagingData<Store>> {
        val config = PagingConfig(
            pageSize = 20,
            prefetchDistance = 2,
            initialLoadSize = 1,
        )
        return Pager(
            config = config,
            remoteMediator = StoreListMediator(
                remoteDataSource = remoteDataSource,
                localDataSource = localDataSource,
                request = GetStoreListRequest(
                    page = 20,
                    limit = 0,
                    sort = sort,
                    searchText = searchText,
                ),
            ),
        ) {
            TODO()
        }.flow.map {
            it.map { entity ->
                entity.toDomain()
            }
        }
    }

    override suspend fun getStoreDetails(): Store = remoteDataSource.getStoreDetails()
        .toDomain()
}