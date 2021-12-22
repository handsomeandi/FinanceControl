package com.example.financecontrol.presentation.auth.login

import com.example.financecontrol.presentation.base.BaseViewModel

class LoginViewModel : BaseViewModel<LoginState, LoginIntent, LoginAction>() {
    override fun handleIntent(intent: LoginIntent) {
        when(intent){
            LoginIntent.OpenRegisterScreen -> mActions.value = LoginAction.OpenRegisterScreen
        }
    }
}