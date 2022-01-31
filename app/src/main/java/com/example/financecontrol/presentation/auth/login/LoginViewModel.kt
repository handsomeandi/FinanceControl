package com.example.financecontrol.presentation.auth.login

import android.util.Patterns
import com.example.financecontrol.presentation.base.BaseViewModel

class LoginViewModel : BaseViewModel<LoginState, LoginIntent, LoginAction>() {
    private var loginData: LoginData? = null

    override fun handleIntent(intent: LoginIntent) {
        when (intent) {
            LoginIntent.OpenRegisterScreen -> mActions.value = LoginAction.OpenRegisterScreen
            LoginIntent.OnLoginPressed -> login()
            is LoginIntent.OnDataChanged -> onDataChanged(intent.loginData)
        }
    }

    private fun onDataChanged(loginData: LoginData) {
        this.loginData = loginData
    }

    private fun login() {
        verifyLoginData({
            mActions.value = LoginAction.SuccessLogin
        }) { e ->
            mActions.value = LoginAction.LoginError(e)
        }
    }

    private fun verifyLoginData(onSuccess: () -> Unit, onError: (e: Exception) -> Unit) {
        if (loginData?.email?.isEmpty() == false
            && loginData?.password?.isEmpty() == false && isValidEmail()
        ) onSuccess()
        else onError(Exception("Wrong input. Try again"))
    }

    private fun isValidEmail() =
        Patterns.EMAIL_ADDRESS.matcher(loginData?.email as CharSequence).matches()
}