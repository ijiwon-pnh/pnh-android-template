package com.pnhglobal.domain.usecase.user

import com.pnhglobal.domain.repository.UserRepository
import javax.inject.Inject

class SignInUseCase @Inject constructor(
    private val repository: UserRepository
) {
    suspend operator fun invoke(userId: String, password: String) = repository.signIn(userId, password)
}