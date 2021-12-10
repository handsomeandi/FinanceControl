package com.example.financecontrol.presentation

import androidx.lifecycle.ViewModel
import com.example.financecontrol.navigation.Screens
import com.github.terrakok.cicerone.Router

class MainActivityViewModel(private val router: Router): ViewModel() {
    fun onStart(){
        router.navigateTo(Screens.AuthFlowScreen())
    }
}