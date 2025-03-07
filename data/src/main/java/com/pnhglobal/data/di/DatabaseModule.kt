package com.pnhglobal.data.di

import android.content.Context
import androidx.room.Room
import com.pnhglobal.data.database.OviPayDatabase
import com.pnhglobal.data.database.dao.StoreDao
import com.pnhglobal.data.database.dao.UserDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(
        @ApplicationContext context: Context
    ): OviPayDatabase = Room.databaseBuilder(context, OviPayDatabase::class.java, "ovipay.db")
        .fallbackToDestructiveMigration()
        .enableMultiInstanceInvalidation()
        .build()

    @Provides
    @Singleton
    fun provideUserDao(database: OviPayDatabase): UserDao = database.userDao()


    @Provides
    @Singleton
    fun provideStoreDao(database: OviPayDatabase): StoreDao = database.storeDao()
}