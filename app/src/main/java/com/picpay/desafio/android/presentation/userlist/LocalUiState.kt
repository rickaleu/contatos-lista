package com.picpay.desafio.android.presentation.userlist

import com.picpay.desafio.android.domain.User

sealed class LocalUiState {
    data class Success(val users: List<User>?): LocalUiState()
    data class Error(val error: String? = null): LocalUiState()
}