package com.picpay.desafio.android.domain.usecase

import com.picpay.desafio.android.data.repository.UserListRepository
import com.picpay.desafio.android.domain.User
import kotlinx.coroutines.flow.Flow

class InsertLocalUserUseCase(private val repository: UserListRepository) {
    operator fun invoke(user: User): Flow<Unit> = repository.insertUser(user)
}