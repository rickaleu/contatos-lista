package com.picpay.desafio.android

import com.picpay.desafio.android.data.datasource.local.model.UserEntity
import com.picpay.desafio.android.data.response.UserResponse
import com.picpay.desafio.android.domain.User

fun getResponseUserListStub() = listOf(
    UserResponse(
        id = 1,
        name = "Joao",
        username = "joao@teste",
        img = ""
    ),
    UserResponse(
        id = 2,
        name = "Bruna",
        username = "bruna@teste",
        img = ""
    ),
    UserResponse(
        id = 3,
        name = "Leticia",
        username = "leticia@teste",
        img = ""
    )
)

fun getEntityUserListStub() = listOf(
    UserEntity(
        id = 1,
        name = "Joao",
        username = "joao@teste",
        img = ""
    ),
    UserEntity(
        id = 2,
        name = "Bruna",
        username = "bruna@teste",
        img = ""
    ),
    UserEntity(
        id = 3,
        name = "Leticia",
        username = "leticia@teste",
        img = ""
    ),
)

fun getDomainUserListStub() = listOf(
    User(
        id = 1,
        name = "Joao",
        username = "joao@teste",
        img = ""
    ),
    User(
        id = 2,
        name = "Bruna",
        username = "bruna@teste",
        img = ""
    ),
    User(
        id = 3,
        name = "Leticia",
        username = "leticia@teste",
        img = ""
    )
)

fun getDomainUserStub(): User = getDomainUserListStub().first()

fun getEntityUserStub(): UserEntity = getEntityUserListStub().first()