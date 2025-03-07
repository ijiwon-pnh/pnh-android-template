package com.pnhglobal.domain.repository

import androidx.paging.PagingData
import com.pnhglobal.domain.model.store.Store
import kotlinx.coroutines.flow.Flow

interface StoreRepository {

    fun getStoreList(
        page: Int?,
        limit: Int?,
        sort: Int?,
        searchText: String?,
    ): Flow<PagingData<Store>>

    suspend fun getStoreDetails(): Store
}