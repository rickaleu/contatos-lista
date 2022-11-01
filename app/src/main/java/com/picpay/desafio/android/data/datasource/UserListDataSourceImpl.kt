package com.picpay.desafio.android.data.datasource

import com.picpay.desafio.android.data.datasource.remote.RemoteDataSource
import com.picpay.desafio.android.data.response.UserResponse
import kotlinx.coroutines.flow.Flow

class UserListDataSourceImpl(
    private val remoteDataSource: RemoteDataSource,
//    private val localDataSource: LocalDataSource
): UserListDataSource {
    override fun getAllUsers(): Flow<List<UserResponse>> {
        return remoteDataSource.getAllUsers()
    }
}