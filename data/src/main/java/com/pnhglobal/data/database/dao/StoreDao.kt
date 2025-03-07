package com.pnhglobal.data.database.dao

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.pnhglobal.data.database.entity.store.StoreEntity

@Dao
interface StoreDao {
    @Query(
        "SELECT * FROM store ORDER BY store_id DESC"
    )
    fun getStoreList(): PagingSource<Int, StoreEntity>

    @Query(
        "SELECT * FROM store WHERE store_id = :storeId"
    )
    fun getStore(storeId: Int): StoreEntity

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllStore(list: List<StoreEntity>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertStore(item: StoreEntity)

    @Update
    suspend fun updateStore(item: StoreEntity)

    @Delete
    suspend fun deleteStore(item: StoreEntity)

    @Query(
        "DELETE FROM store"
    )
    suspend fun deleteAllStore()
}