package com.pnhglobal.data.network.service

import com.pnhglobal.data.network.model.user.NetworkUser
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.Part

interface UserService {
    companion object {
        private const val API_ROUTE = "user/"

        private const val GET_USER_INFO = "getUserInfo"
        private const val LOGIN_USER = "login"
        private const val JOIN_USER = "join"
    }

    @GET("$API_ROUTE$GET_USER_INFO")
    suspend fun getUserInfo(): NetworkUser

    @FormUrlEncoded
    @POST("$API_ROUTE$LOGIN_USER")
    suspend fun userLogin(
        @Field("user_id") userId: String,
        @Field("password") password: String,
    ): NetworkUser

    @Multipart
    @POST("$API_ROUTE$JOIN_USER")
    suspend fun userJoin(
        @Part("user_id") userId: RequestBody,
        @Part("password") password: RequestBody,
        @Part("user_name") userName: RequestBody,
        @Part multipart: MultipartBody.Part?,
    ): String
}