package com.picpay.desafio.android.data.datasource.local

import com.picpay.desafio.android.data.datasource.local.model.UserEntity
import kotlinx.coroutines.flow.Flow

interface LocalDataSource {

    fun getAllLocalUsers(): Flow<List<UserEntity>>
    fun insertUser(user: UserEntity): Flow<Unit>
}