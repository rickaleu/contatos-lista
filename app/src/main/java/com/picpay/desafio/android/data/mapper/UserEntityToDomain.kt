package com.picpay.desafio.android.data.mapper

import com.picpay.desafio.android.data.datasource.local.model.UserEntity
import com.picpay.desafio.android.domain.User

fun List<UserEntity>.toDomain(): List<User> = this.map { it.toDomain() }

fun List<User>.toEntity(): List<UserEntity> = this.map { it.toEntity() }

fun User.toEntity() = UserEntity(
    id = id,
    name = name,
    username = username,
    img = img
)

fun UserEntity.toDomain() = User(
    id = id,
    name = name,
    username = username,
    img = img
)