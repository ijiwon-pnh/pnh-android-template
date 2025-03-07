package com.pnhglobal.data.network.model.request

data class GetStoreListRequest(
    val page: Int?,
    val limit: Int?,
    val sort: Int? = null,
    val searchText: String? = null,
)