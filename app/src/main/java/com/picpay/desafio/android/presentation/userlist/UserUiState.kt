package com.picpay.desafio.android.presentation.userlist

import com.picpay.desafio.android.domain.User

sealed class UserUiState {
    object Loading: UserUiState()
    data class Success(val users: List<User>): UserUiState()
    data class Error(val error: String? = null): UserUiState()
}