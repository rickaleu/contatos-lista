package com.picpay.desafio.android.di

import com.picpay.desafio.android.domain.UserListRepository
import com.picpay.desafio.android.domain.UserListRepositoryImpl
import com.picpay.desafio.android.presentation.userlist.UserListViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val userListModule = module {
    factory<UserListRepository> {
        UserListRepositoryImpl()
    }

    viewModel {
        UserListViewModel(
            repository = get()
        )
    }
}