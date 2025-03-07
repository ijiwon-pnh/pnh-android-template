package com.pnhglobal.ovipay.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.pnhglobal.domain.usecase.store.GetNearbyStoresUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getNearbyStoresUseCase: GetNearbyStoresUseCase,
) : ViewModel() {

    private val _isLoading = MutableStateFlow(false)

    val isLoading = _isLoading.asStateFlow()

    // TODO : sort, search text

    val nearbyStores = getNearbyStoresUseCase.invoke(TODO())
        .cachedIn(viewModelScope)
}