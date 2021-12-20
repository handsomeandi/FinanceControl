package com.example.financecontrol.presentation.auth.login

import com.example.financecontrol.presentation.base.BaseViewModel

class LoginViewModel : BaseViewModel<LoginState, LoginIntent, LoginAction>() {
    override fun intentToAction(intent: LoginIntent): LoginAction {
        return LoginAction.SomeAction
    }

    override fun handleAction(action: LoginAction) {
    }
}