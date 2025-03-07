package com.pnhglobal.domain.repository

import com.pnhglobal.domain.model.user.User
import java.io.File

interface UserRepository {

    suspend fun getUserInfo(): User

    suspend fun signIn(userId: String, password: String): User

    suspend fun signUp(userId: String, password: String, username: String, avatar: File?): Any
}