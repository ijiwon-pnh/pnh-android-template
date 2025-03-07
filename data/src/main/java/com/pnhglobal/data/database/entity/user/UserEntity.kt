package com.pnhglobal.data.database.entity.user

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user")
data class UserEntity(
    @PrimaryKey(autoGenerate = true) val key: Int = 0,
    val id: Int,
    val name: String?,
)
