package com.picpay.desafio.android.data.datasource.local

import com.picpay.desafio.android.data.datasource.local.dao.UserDao
import com.picpay.desafio.android.data.datasource.local.model.UserEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class LocalDataSourceImpl(
    private val dao: UserDao
): LocalDataSource {
    override fun getAllLocalUsers(): Flow<List<UserEntity>> {
        return flow {
            emit(dao.getAllUsers())
        }
    }

    override fun insertUser(user: UserEntity): Flow<Unit> {
        return flow {
            emit(dao.insertUser(user))
        }
    }
}