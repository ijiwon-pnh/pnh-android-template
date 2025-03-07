package com.pnhglobal.data.database.entity.store

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(
    tableName = "store",
    indices = [
        Index(
            "store_id",
            unique = true,
        ),
    ],
)
data class StoreEntity(
    @PrimaryKey
    @ColumnInfo("store_id") val storeId: Int = 0,
    @ColumnInfo("store_name") val storeName: String? = null,
)
