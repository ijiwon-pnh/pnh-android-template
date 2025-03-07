package com.pnhglobal.domain.usecase.store

import com.pnhglobal.domain.repository.StoreRepository
import javax.inject.Inject

class GetStoreDetailUseCase @Inject constructor(
    private val repository: StoreRepository
) {
    suspend operator fun invoke() = repository.getStoreDetails()
}