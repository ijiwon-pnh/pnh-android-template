package com.pnhglobal.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.pnhglobal.data.database.dao.StoreDao
import com.pnhglobal.data.database.dao.UserDao
import com.pnhglobal.data.database.entity.store.StoreEntity
import com.pnhglobal.data.database.entity.user.UserEntity

/** 예시 */
@Database(
    entities = [
        UserEntity::class,
        StoreEntity::class,
    ],
    version = 1,
    exportSchema = false,
)
abstract class OviPayDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
    abstract fun storeDao(): StoreDao
}