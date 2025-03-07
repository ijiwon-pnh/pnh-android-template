package com.pnhglobal.data.di

import com.pnhglobal.data.datasource.StoreLocalDataSource
import com.pnhglobal.data.datasource.StoreLocalDataSourceImpl
import com.pnhglobal.data.datasource.StoreRemoteDataSource
import com.pnhglobal.data.datasource.StoreRemoteDataSourceImpl
import com.pnhglobal.data.datasource.UserLocalDataSource
import com.pnhglobal.data.datasource.UserLocalDataSourceImpl
import com.pnhglobal.data.datasource.UserRemoteDataSource
import com.pnhglobal.data.datasource.UserRemoteDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class DataSourceModule {

    @Binds
    @Singleton
    abstract fun bindStoreRemoteDataSource(
        dataSource: StoreRemoteDataSourceImpl
    ): StoreRemoteDataSource

    @Binds
    @Singleton
    abstract fun bindStoreLocalDataSource(
        dataSource: StoreLocalDataSourceImpl
    ): StoreLocalDataSource

    @Binds
    @Singleton
    abstract fun bindUserRemoteDataSource(
        dataSource: UserRemoteDataSourceImpl
    ): UserRemoteDataSource

    @Binds
    @Singleton
    abstract fun bindUserLocalDataSource(
        dataSource: UserLocalDataSourceImpl
    ): UserLocalDataSource
}