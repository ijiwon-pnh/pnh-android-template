package com.pnhglobal.domain.usecase.store

import com.pnhglobal.domain.repository.StoreRepository
import javax.inject.Inject

class GetStoreListUseCase @Inject constructor(
    private val repository: StoreRepository
) {
    operator fun invoke(query: GetStoreListQuery) = with(query) {
        repository.getStoreList(page, limit, sort, searchText)
    }
}

data class GetStoreListQuery(
    val page: Int?,
    val limit: Int?,
    val sort: Int?,
    val searchText: String?,
)