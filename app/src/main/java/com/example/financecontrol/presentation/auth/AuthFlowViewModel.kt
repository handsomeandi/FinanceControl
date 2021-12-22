package com.example.financecontrol.presentation.auth

import com.example.financecontrol.presentation.base.BaseViewModel
import com.example.financecontrol.presentation.base.State

sealed class AuthFlowState : State {
}

class AuthFlowViewModel : BaseViewModel<AuthFlowState, AuthFlowIntent, AuthFlowAction>() {

    override fun handleIntent(intent: AuthFlowIntent) {
        when (intent) {
            AuthFlowIntent.OpenRootScreen -> mActions.value = AuthFlowAction.OpenRegisterScreen
        }
    }
}