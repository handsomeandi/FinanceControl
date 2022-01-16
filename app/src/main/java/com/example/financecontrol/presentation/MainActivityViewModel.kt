package com.example.financecontrol.presentation

import com.example.financecontrol.presentation.base.BaseViewModel


class MainActivityViewModel : BaseViewModel<MainState, MainIntent, MainAction>() {
    override fun handleIntent(intent: MainIntent) {
        when (intent) {
            MainIntent.OpenAuthFlowScreen -> mActions.value = MainAction.OpenAuthFlowScreen
        }
    }
}