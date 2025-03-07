package com.pnhglobal.domain.usecase.user

import com.pnhglobal.domain.repository.UserRepository
import javax.inject.Inject

class GetUserInfoUseCase @Inject constructor(
    private val repository: UserRepository
) {
    suspend operator fun invoke() = repository.getUserInfo()
}