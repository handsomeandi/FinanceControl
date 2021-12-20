package com.example.financecontrol.presentation.auth.register

import com.example.financecontrol.presentation.base.BaseViewModel

class RegisterViewModel: BaseViewModel<RegisterState, RegisterIntent, RegisterAction>() {
    override fun intentToAction(intent: RegisterIntent): RegisterAction {
        return RegisterAction.SomeAction
    }

    override fun handleAction(action: RegisterAction) {
    }


}