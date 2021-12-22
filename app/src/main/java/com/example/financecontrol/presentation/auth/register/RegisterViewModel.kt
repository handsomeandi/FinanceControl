package com.example.financecontrol.presentation.auth.register

import com.example.financecontrol.presentation.base.BaseViewModel

class RegisterViewModel: BaseViewModel<RegisterState, RegisterIntent, RegisterAction>() {

    override fun handleIntent(intent: RegisterIntent) {
        when(intent){
            RegisterIntent.OpenLoginScreen -> mActions.value = RegisterAction.OpenLoginScreen
        }
    }
}