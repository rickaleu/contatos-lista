package com.picpay.desafio.android.domain.usecase

import com.picpay.desafio.android.data.repository.UserListRepository
import com.picpay.desafio.android.domain.User
import kotlinx.coroutines.flow.Flow

class GetAllRemoteUsersUseCase(private val repository: UserListRepository) {
    operator fun invoke(): Flow<List<User>> = repository.getAllUsers()
}