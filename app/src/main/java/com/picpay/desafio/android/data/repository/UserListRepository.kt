package com.picpay.desafio.android.data.repository

import com.picpay.desafio.android.domain.User
import kotlinx.coroutines.flow.Flow

interface UserListRepository {

    fun getAllUsers(): Flow<List<User>>
    fun getAllLocalUsers(): Flow<List<User>>
    fun insertUser(user: User): Flow<Unit>
}