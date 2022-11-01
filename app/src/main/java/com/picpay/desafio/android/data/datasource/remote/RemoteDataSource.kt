package com.picpay.desafio.android.data.datasource.remote

import com.picpay.desafio.android.data.response.UserResponse
import kotlinx.coroutines.flow.Flow

interface RemoteDataSource {

    fun getAllUsers(): Flow<List<UserResponse>>
}