package com.picpay.desafio.android.di

import com.picpay.desafio.android.data.datasource.UserListDataSource
import com.picpay.desafio.android.data.datasource.UserListDataSourceImpl
import com.picpay.desafio.android.data.datasource.remote.RemoteDataSource
import com.picpay.desafio.android.data.datasource.remote.RemoteDataSourceImpl
import com.picpay.desafio.android.data.repository.UserListRepository
import com.picpay.desafio.android.data.repository.UserListRepositoryImpl
import com.picpay.desafio.android.data.service.RetrofitClient
import com.picpay.desafio.android.presentation.userlist.UserListViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.scope.Scope
import org.koin.dsl.module

val userListModule = module {
    viewModel {
        UserListViewModel(
            repository = getUserListRepository()
        )
    }
}

private fun Scope.getUserListRepository(): UserListRepository {
    return UserListRepositoryImpl(datasource = getUserListDataSource())
}

private fun Scope.getUserListDataSource(): UserListDataSource {
    return UserListDataSourceImpl(
        remoteDataSource = getRemoteDataSource()
//        localDataSource = getLocalDataSource()
    )
}

private fun Scope.getRemoteDataSource(): RemoteDataSource {
    return RemoteDataSourceImpl(service = getPicPayService())
}

private fun Scope.getPicPayService() = RetrofitClient.picPayService