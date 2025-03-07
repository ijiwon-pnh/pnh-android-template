package com.pnhglobal.data.di

import com.pnhglobal.data.repository.StoreRepositoryImpl
import com.pnhglobal.data.repository.UserRepositoryImpl
import com.pnhglobal.domain.repository.StoreRepository
import com.pnhglobal.domain.repository.UserRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindUserRepository(repository: UserRepositoryImpl): UserRepository

    @Binds
    @Singleton
    abstract fun bindStoreRepository(repository: StoreRepositoryImpl): StoreRepository
}