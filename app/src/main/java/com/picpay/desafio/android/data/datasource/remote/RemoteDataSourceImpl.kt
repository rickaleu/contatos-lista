package com.picpay.desafio.android.data.datasource.remote

import com.picpay.desafio.android.data.response.UserResponse
import com.picpay.desafio.android.data.service.PicPayService
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class RemoteDataSourceImpl(
    private val service: PicPayService
): RemoteDataSource {

    override fun getAllUsers(): Flow<List<UserResponse>> {
        return flow {
            emit(service.getUsers())
        }
    }
}