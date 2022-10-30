package com.picpay.desafio.android.presentation.userlist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.picpay.desafio.android.domain.User
import com.picpay.desafio.android.domain.UserListRepository
import kotlinx.coroutines.launch

class UserListViewModel(
    private val repository: UserListRepository
): ViewModel() {

    private val _userListMutableLiveData: MutableLiveData<List<User>> = MutableLiveData()
    val userList: LiveData<List<User>>
        get() = _userListMutableLiveData

    fun getUserList() {
        viewModelScope.launch {

        }
    }
}