package com.example.financecontrol.di

import com.example.financecontrol.presentation.MainActivityViewModel
import com.example.financecontrol.presentation.auth.AuthFlowViewModel
import com.example.financecontrol.presentation.auth.login.LoginViewModel
import com.example.financecontrol.presentation.auth.register.RegisterViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel {
        MainActivityViewModel()
    }
    viewModel {
        AuthFlowViewModel()
    }
    viewModel{
        RegisterViewModel()
    }
    viewModel{
        LoginViewModel()
    }
}