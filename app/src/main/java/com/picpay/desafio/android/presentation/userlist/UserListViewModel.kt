package com.picpay.desafio.android.presentation.userlist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.picpay.desafio.android.data.repository.UserListRepository
import com.picpay.desafio.android.domain.User
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch

class UserListViewModel(
    private val repository: UserListRepository,
    private val dispatcher: CoroutineDispatcher = Dispatchers.IO
): ViewModel() {

    private val _userListMutableLiveData: MutableLiveData<UserUiState> = MutableLiveData()
    val userList: LiveData<UserUiState>
        get() = _userListMutableLiveData

    fun getUserList() {
        viewModelScope.launch {
            repository.getAllUsers()
                .flowOn(dispatcher)
                .onStart { showLoading() }
                .catch { throwable -> handleOnError(throwable) }
                .collect { users -> handleOnSuccess(users) }
        }
    }

    private fun showLoading() {
        _userListMutableLiveData.value = UserUiState.Loading
    }

    private fun handleOnSuccess(users: List<User>) {
        _userListMutableLiveData.value = UserUiState.Success(users)
    }

    private fun handleOnError(throwable: Throwable) {
        _userListMutableLiveData.value = UserUiState.Error(throwable.message)
    }
}