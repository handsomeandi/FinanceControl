package com.example.financecontrol.di

import com.example.financecontrol.presentation.MainActivityViewModel
import com.example.financecontrol.presentation.auth.AuthFlowViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { parameters ->
        MainActivityViewModel(parameters.get())
    }
    viewModel {
        AuthFlowViewModel()
    }
}