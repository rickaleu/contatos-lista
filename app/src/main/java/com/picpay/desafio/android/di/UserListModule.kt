package com.picpay.desafio.android.di

import com.picpay.desafio.android.data.datasource.UserListDataSource
import com.picpay.desafio.android.data.datasource.UserListDataSourceImpl
import com.picpay.desafio.android.data.datasource.local.LocalDataSource
import com.picpay.desafio.android.data.datasource.local.LocalDataSourceImpl
import com.picpay.desafio.android.data.datasource.local.db.getDataBase
import com.picpay.desafio.android.data.datasource.remote.RemoteDataSource
import com.picpay.desafio.android.data.datasource.remote.RemoteDataSourceImpl
import com.picpay.desafio.android.data.repository.UserListRepository
import com.picpay.desafio.android.data.repository.UserListRepositoryImpl
import com.picpay.desafio.android.data.service.RetrofitClient
import com.picpay.desafio.android.domain.usecase.GetAllLocalUsersUseCase
import com.picpay.desafio.android.domain.usecase.GetAllRemoteUsersUseCase
import com.picpay.desafio.android.domain.usecase.InsertLocalUserUseCase
import com.picpay.desafio.android.presentation.userlist.UserListViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.scope.Scope
import org.koin.dsl.module

val userListModule = module {
    viewModel {
        UserListViewModel(
            getAllRemoteUsersUseCase = getAllRemoteUsersUseCase(),
            getAllLocalUsersUseCase = getAllLocalUsersUseCase()
        )
    }
}

private fun Scope.getAllRemoteUsersUseCase() = GetAllRemoteUsersUseCase(repository = getUserListRepository())

private fun Scope.getAllLocalUsersUseCase() = GetAllLocalUsersUseCase(repository = getUserListRepository())

//Scope removed so as not to break the app
private fun Scope.getInsertLocalUserUseCase() = InsertLocalUserUseCase(repository = getUserListRepository())

private fun Scope.getUserListRepository(): UserListRepository {
    return UserListRepositoryImpl(datasource = getUserListDataSource())
}

private fun Scope.getUserListDataSource(): UserListDataSource {
    return UserListDataSourceImpl(
        remoteDataSource = getRemoteDataSource(),
        localDataSource = getLocalDataSource()
    )
}

private fun Scope.getRemoteDataSource(): RemoteDataSource {
    return RemoteDataSourceImpl(service = getPicPayService())
}

private fun Scope.getPicPayService() = RetrofitClient.picPayService

private fun Scope.getLocalDataSource(): LocalDataSource {
    return LocalDataSourceImpl(dao = getUserDao())
}

private fun Scope.getUserDao() = UserDatabase().userDAO()

private fun Scope.UserDatabase() = getDataBase(context = get())

