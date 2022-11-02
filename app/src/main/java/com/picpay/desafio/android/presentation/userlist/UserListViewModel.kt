package com.picpay.desafio.android.presentation.userlist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.picpay.desafio.android.domain.User
import com.picpay.desafio.android.domain.usecase.GetAllLocalUsersUseCase
import com.picpay.desafio.android.domain.usecase.GetAllRemoteUsersUseCase
import com.picpay.desafio.android.domain.usecase.InsertLocalUserUseCase
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch

class UserListViewModel(
    private val getAllRemoteUsersUseCase: GetAllRemoteUsersUseCase,
    private val getAllLocalUsersUseCase: GetAllLocalUsersUseCase,
    private val dispatcher: CoroutineDispatcher = Dispatchers.IO
): ViewModel() {

    private val _userListRemoteMutableLiveData: MutableLiveData<RemoteUiState> = MutableLiveData()
    val userListRemote: LiveData<RemoteUiState>
        get() = _userListRemoteMutableLiveData

    private val _userListLocalMutableLiveData: MutableLiveData<LocalUiState> = MutableLiveData()
    val userListLocal: LiveData<LocalUiState>
        get() = _userListLocalMutableLiveData

    //Variable commented so as not to break the app
//    private var _state: MutableLiveData<InsertLocalState> = MutableLiveData()
//    val state: LiveData<InsertLocalState>
//        get() = _state

    fun getRemoteUserList() {
        viewModelScope.launch {
            getAllRemoteUsersUseCase()
                .flowOn(dispatcher)
                .onStart { showLoading() }
                .catch { throwable -> handleOnError(throwable) }
                .collect { users -> handleOnSuccess(users) }
        }
    }

    fun getLocalUserList() {
        viewModelScope.launch {
            getAllLocalUsersUseCase()
                .flowOn(dispatcher)
                .onStart { showLoading() }
                .catch { throwable -> handleLocalOnError(throwable) }
                .collect { users -> handleLocalOnSuccess(users) }
        }
    }

    //Method commented so as not to break the app
//    fun insertLocalUser(user: User) {
//        viewModelScope.launch(dispatcher) {
//            insertLocalUserUseCase(user)
//                .collect { setFavoriteState(true) }
//        }
//    }

    //Method commented so as not to break the app
//    private fun setFavoriteState(hasBeenInserted: Boolean) {
//        _state.postValue(InsertLocalState(hasBeenInserted))
//    }

    private fun showLoading() {
        _userListRemoteMutableLiveData.value = RemoteUiState.Loading
    }

    private fun handleOnSuccess(users: List<User>?) {
        _userListRemoteMutableLiveData.value = RemoteUiState.Success(users)
    }

    private fun handleOnError(throwable: Throwable) {
        _userListRemoteMutableLiveData.value = RemoteUiState.Error(throwable.message)
    }

    private fun handleLocalOnSuccess(users: List<User>?) {
        _userListLocalMutableLiveData.value = LocalUiState.Success(users)
    }

    private fun handleLocalOnError(throwable: Throwable) {
        _userListRemoteMutableLiveData.value = RemoteUiState.Error(throwable.message)
    }
}