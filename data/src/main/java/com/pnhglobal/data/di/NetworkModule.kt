package com.pnhglobal.data.di

import android.content.Context
import com.pnhglobal.data.network.service.StoreService
import com.pnhglobal.data.network.service.UserService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.Cache
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.File
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun provideUserService(
        retrofit: Retrofit,
    ): UserService = retrofit.create(UserService::class.java)

    @Provides
    @Singleton
    fun provideStoreService(
        retrofit: Retrofit,
    ): StoreService = retrofit.create(StoreService::class.java)

    @Provides
    @Singleton
    fun provideRetrofit(
        client: OkHttpClient,
        converterFactory: Converter.Factory,
    ): Retrofit = Retrofit.Builder()
        .baseUrl("BuildConfig.BASE_URL")
        .client(client)
        .addConverterFactory(converterFactory)
        .build()

    @Singleton
    @Provides
    fun provideOkHttpClient(
        @ApplicationContext context: Context,
        logging: HttpLoggingInterceptor,
        deviceHeaderInfo: String,
    ): OkHttpClient = OkHttpClient.Builder().apply {
        addInterceptor { chain ->
            // TODO : Interceptor 분리
            val response = chain.request().newBuilder().apply {
                /*
                TODO : 유저 Access Token 로그인 시 받아서 Bearer 로 전달
                val accessToken = userData.value?.accessToken
                if (!accessToken.isNullOrEmpty()) {
                    addHeader("Authorization", "Bearer $accessToken")
                }*/
                removeHeader("User-Agent")
                addHeader("X-Device-Info", deviceHeaderInfo)
                // addHeader("User-Agent", appInfo.getUserAgent())
            }.build()

            chain.proceed(response)
        }

        addInterceptor(logging)

        cache(
            Cache(
                directory = File(context.cacheDir, "http_cache"), maxSize = 50L * 1024L * 1024L
            )// .clearMalformedUrls()
        )

        connectTimeout(30, TimeUnit.SECONDS)

        readTimeout(30, TimeUnit.SECONDS)

        //authenticator(authenticator)
    }.build()

    @Provides
    @Singleton
    fun provideLoggingInterceptor(): HttpLoggingInterceptor = HttpLoggingInterceptor().apply {
        level = if (true/* TODO BuildConfig.DEBUG */) {
            HttpLoggingInterceptor.Level.BODY
        } else {
            HttpLoggingInterceptor.Level.NONE
        }
    }

    @Provides
    @Singleton
    fun provideConverterFactory(): Converter.Factory = GsonConverterFactory.create()
}