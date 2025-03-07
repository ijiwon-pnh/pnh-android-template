package com.pnhglobal.data.database.entity.user

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

/** 예시 */
@Entity(
    tableName = "user",
    indices = [
        Index(
            "user_id",
            unique = true,
        ),
    ],
)
data class UserEntity(
    @PrimaryKey(autoGenerate = true) @ColumnInfo("num") val num: Int = 0,
    @ColumnInfo("user_id") val userId: Int,
    @ColumnInfo("user_name") val userName: String?,
)
