package com.pnhglobal.data.utils

import com.pnhglobal.data.database.entity.store.StoreEntity
import com.pnhglobal.data.network.model.store.NetworkStore
import com.pnhglobal.data.network.model.user.NetworkUser
import com.pnhglobal.domain.model.store.Store
import com.pnhglobal.domain.model.user.User

fun NetworkUser.toDomain(): User = User(id = this.userId, name = this.userName)

fun NetworkStore.toDomain(): Store = Store(
    id = this.storeId,
    name = this.storeName,
)

fun StoreEntity.toDomain(): Store = Store(
    id = this.storeId,
    name = this.storeName,
)