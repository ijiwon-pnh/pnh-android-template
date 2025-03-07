package com.pnhglobal.data.database.dao

import androidx.room.Dao
import androidx.room.Query
import com.pnhglobal.data.database.entity.user.UserEntity

/** 예시 */
@Dao
interface UserDao {
    @Query(
        "SELECT * FROM user"
    )
    suspend fun getUserList(): List<UserEntity>
}