package com.pnhglobal.domain.di

import com.pnhglobal.domain.repository.StoreRepository
import com.pnhglobal.domain.repository.UserRepository
import com.pnhglobal.domain.usecase.store.GetStoreDetailUseCase
import com.pnhglobal.domain.usecase.store.GetNearbyStoresUseCase
import com.pnhglobal.domain.usecase.user.GetUserInfoUseCase
import com.pnhglobal.domain.usecase.user.SignInUseCase
import com.pnhglobal.domain.usecase.user.SignUpUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {

    @Provides
    @Singleton
    fun provideRequestGetUserInfoUseCase(
        repository: UserRepository
    ): GetUserInfoUseCase = GetUserInfoUseCase(repository)

    @Provides
    @Singleton
    fun provideRequestUserJoinUseCase(
        repository: UserRepository
    ): SignUpUseCase = SignUpUseCase(repository)

    @Provides
    @Singleton
    fun provideRequestUserLoginUseCase(
        repository: UserRepository
    ): SignInUseCase = SignInUseCase(repository)

    @Provides
    @Singleton
    fun provideRequestGetStoreDetailUseCase(
        repository: StoreRepository
    ): GetStoreDetailUseCase = GetStoreDetailUseCase(repository)

    @Provides
    @Singleton
    fun provideRequestGetStoreListUseCase(
        repository: StoreRepository
    ): GetNearbyStoresUseCase = GetNearbyStoresUseCase(repository)
}