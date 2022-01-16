package com.example.financecontrol.presentation.auth.register

import android.util.Patterns
import com.example.financecontrol.presentation.base.BaseViewModel
import java.lang.Exception

class RegisterViewModel : BaseViewModel<RegisterState, RegisterIntent, RegisterAction>() {
    private var registerData: RegisterData? = null

    override fun handleIntent(intent: RegisterIntent) {
        when (intent) {
            RegisterIntent.OnLoginPressed -> mActions.value = RegisterAction.OpenLoginScreen
            is RegisterIntent.OnDataChanged -> onDataChanged(intent.data)
            RegisterIntent.OnRegisterPressed -> register()
        }
    }

    private fun onDataChanged(registerData: RegisterData) {
        this.registerData = registerData
    }

    private fun register() {
        verifyRegisterData({
            mActions.value = RegisterAction.SuccessRegister
        }){ e ->
            mActions.value = RegisterAction.RegisterError(e)
        }
    }

    private fun verifyRegisterData(onSuccess: () -> Unit, onError: (e: Exception) -> Unit) {
        if (registerData?.username?.isEmpty() == false
            && registerData?.email?.isEmpty() == false
            && registerData?.password?.isEmpty() == false
            && registerData?.passwordRepeat?.isEmpty() == false && isPasswordsMatch() && isValidEmail()) onSuccess()
        else onError(Exception("Wrong input. Try again"))
    }

    private fun isValidEmail() = Patterns.EMAIL_ADDRESS.matcher(registerData?.email as CharSequence).matches()

    private fun isPasswordsMatch() = registerData?.password == registerData?.passwordRepeat ?: false
}