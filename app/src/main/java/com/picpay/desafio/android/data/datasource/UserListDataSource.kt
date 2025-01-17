package com.picpay.desafio.android.data.datasource

import com.picpay.desafio.android.data.datasource.local.model.UserEntity
import com.picpay.desafio.android.data.response.UserResponse
import kotlinx.coroutines.flow.Flow

interface UserListDataSource {

    fun getAllUsers(): Flow<List<UserResponse>>
    fun getAllLocalUsers(): Flow<List<UserEntity>>
    fun insertUser(user: UserEntity): Flow<Unit>
}