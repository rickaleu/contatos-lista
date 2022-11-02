package com.picpay.desafio.android.data.repository

import com.picpay.desafio.android.data.datasource.UserListDataSource
import com.picpay.desafio.android.data.mapper.toDomain
import com.picpay.desafio.android.data.mapper.toEntity
import com.picpay.desafio.android.domain.User
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class UserListRepositoryImpl(private val datasource: UserListDataSource): UserListRepository {

    override fun getAllUsers(): Flow<List<User>> {
        return datasource.getAllUsers().map { it.toDomain() }
    }

    override fun getAllLocalUsers(): Flow<List<User>> {
        return datasource.getAllLocalUsers().map { it.toDomain() }
    }

    override fun insertUser(user: User): Flow<Unit> {
        return datasource.insertUser(user.toEntity())
    }

}