package com.picpay.desafio.android.data.datasource

import com.picpay.desafio.android.data.datasource.local.LocalDataSource
import com.picpay.desafio.android.data.datasource.local.model.UserEntity
import com.picpay.desafio.android.data.datasource.remote.RemoteDataSource
import com.picpay.desafio.android.data.response.UserResponse
import kotlinx.coroutines.flow.Flow

class UserListDataSourceImpl(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource
): UserListDataSource {
    override fun getAllUsers(): Flow<List<UserResponse>> {
        return remoteDataSource.getAllUsers()
    }

    override fun getAllLocalUsers(): Flow<List<UserEntity>> {
        return localDataSource.getAllLocalUsers()
    }

    override fun insertUser(user: UserEntity): Flow<Unit> {
        return localDataSource.insertUser(user)
    }
}