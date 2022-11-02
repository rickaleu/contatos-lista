package com.picpay.desafio.android.presentation.userlist

import com.picpay.desafio.android.domain.User

sealed class RemoteUiState {
    object Loading: RemoteUiState()
    data class Success(val users: List<User>?): RemoteUiState()
    data class Error(val error: String? = null): RemoteUiState()
}