package com.picpay.desafio.android.data.mapper

import com.picpay.desafio.android.data.response.UserResponse
import com.picpay.desafio.android.domain.User

fun List<UserResponse>.toDomain(): List<User> = this.map { it.toDomain() }

private fun UserResponse.toDomain() = User(
    id = id,
    name = name,
    username = username,
    img = img
)