package com.pnhglobal.data.database.entity.store

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "store")
data class StoreEntity(
    @PrimaryKey
    val id: Int = 0,
    val name: String? = null,
)
