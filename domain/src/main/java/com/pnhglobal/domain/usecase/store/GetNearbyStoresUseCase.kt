package com.pnhglobal.domain.usecase.store

import com.pnhglobal.domain.repository.StoreRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class GetNearbyStoresUseCase @Inject constructor(
    private val repository: StoreRepository
) {
    operator fun invoke(query: GetNearbyStoresQuery) = with(query) {
        repository.getNearbyStores(sort, searchText)
    }
}

data class GetNearbyStoresQuery(val sort: Int?, val searchText: String?)