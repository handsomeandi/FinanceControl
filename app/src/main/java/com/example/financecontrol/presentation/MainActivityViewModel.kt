package com.example.financecontrol.presentation

import androidx.lifecycle.ViewModel
import com.example.financecontrol.presentation.navigation.Screens
import com.github.terrakok.cicerone.Router

//TODO: Make states and intents
class MainActivityViewModel(private val router: Router): ViewModel() {
    fun onStart(){
        router.navigateTo(Screens.AuthFlowScreen())
    }
}