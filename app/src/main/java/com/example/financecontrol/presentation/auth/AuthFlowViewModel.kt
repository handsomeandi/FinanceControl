package com.example.financecontrol.presentation.auth

import com.example.financecontrol.presentation.base.BaseViewModel
import com.example.financecontrol.presentation.base.State
import com.example.financecontrol.presentation.navigation.Screens.RegisterScreen
import com.github.terrakok.cicerone.androidx.FragmentScreen

sealed class AuthFlowState : State {
    class CurrentScreen(val screen: FragmentScreen) : AuthFlowState()
}

class AuthFlowViewModel : BaseViewModel<AuthFlowState, AuthFlowIntent, AuthFlowAction>() {
    override fun intentToAction(intent: AuthFlowIntent): AuthFlowAction {
        return when (intent) {
            AuthFlowIntent.OpenRootScreen -> AuthFlowAction.OpenRegisterScreen
        }
    }

    override fun handleAction(action: AuthFlowAction) {
        mState.value = AuthFlowState.CurrentScreen(RegisterScreen())
    }
}