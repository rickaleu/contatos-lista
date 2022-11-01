package com.picpay.desafio.android.data.datasource

import com.picpay.desafio.android.data.response.UserResponse
import kotlinx.coroutines.flow.Flow

interface UserListDataSource {

    fun getAllUsers(): Flow<List<UserResponse>>
}