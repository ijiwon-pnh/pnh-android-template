package com.pnhglobal.domain.usecase.user

import com.pnhglobal.domain.repository.UserRepository
import java.io.File
import javax.inject.Inject

class SignUpUseCase @Inject constructor(
    private val repository: UserRepository
) {
    suspend operator fun invoke(command: SignUpCommand) = with(command) {
        repository.signUp(userId, password, username, avatar)
    }
}

data class SignUpCommand(
    val userId: String,
    val password: String,
    val username: String,
    val avatar: File?,
)