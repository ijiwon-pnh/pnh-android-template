package com.pnhglobal.data.repository

import com.pnhglobal.data.datasource.UserLocalDataSource
import com.pnhglobal.data.datasource.UserRemoteDataSource
import com.pnhglobal.domain.model.user.User
import com.pnhglobal.domain.repository.UserRepository
import java.io.File
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
    private val remoteDataSource: UserRemoteDataSource,
    private val localDataSource: UserLocalDataSource,
) : UserRepository {
    override suspend fun getUserInfo(): User {
        TODO()
    }

    override suspend fun signIn(userId: String, password: String): User {
        TODO()
    }

    override suspend fun signUp(
        userId: String,
        password: String,
        userName: String,
        multipart: File?,
    ) {
        TODO()
    }
}