package com.example.financecontrol.presentation.auth.login

import android.util.Log
import android.widget.EditText
import android.widget.Toast
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.financecontrol.R
import com.example.financecontrol.config.AppExt.setSpannableString
import com.example.financecontrol.databinding.FragmentLoginBinding
import com.example.financecontrol.presentation.auth.register.RegisterData
import com.example.financecontrol.presentation.auth.register.RegisterIntent
import com.example.financecontrol.presentation.base.BaseFragment
import com.example.financecontrol.presentation.base.State
import com.example.financecontrol.presentation.base.ViewAction
import com.example.financecontrol.presentation.base.ViewIntent
import com.example.financecontrol.presentation.navigation.Screens.RegisterScreen
import java.lang.Exception
import kotlin.math.log

sealed class LoginState : State{
    class CurrentLoginData(val data: LoginData): LoginState()
}

sealed class LoginAction : ViewAction {
    object OpenRegisterScreen : LoginAction()
    object SuccessLogin : LoginAction()
    class LoginError(val error: Exception) : LoginAction()
}

sealed class LoginIntent : ViewIntent {
    object OpenRegisterScreen : LoginIntent()
    object OnLoginPressed : LoginIntent()
    class OnDataChanged(val loginData: LoginData) : LoginIntent()
}


class LoginFragment :
    BaseFragment<FragmentLoginBinding, LoginState, LoginAction, LoginIntent, LoginViewModel>(R.layout.fragment_login) {
    override val binding: FragmentLoginBinding by viewBinding()
    override val viewModel: LoginViewModel by viewModels()
    private val loginData = LoginData()

    override fun onStart() {
        super.onStart()
        initListeners()
        with(binding) {
            tvSignUp.setSpannableString(tvSignUp.text.toString(), R.color.blue, 23 to 30) {
                dispatchIntent(LoginIntent.OpenRegisterScreen)
            }
        }
    }

    private fun initListeners(){
        with(binding){
            etEmail.onTextChanged{
                loginData.email = it
            }
            etPassword.onTextChanged {
                loginData.password = it
            }
            btnSignIn.setOnClickListener {
                viewModel.sendIntent(LoginIntent.OnLoginPressed)
            }
        }
    }

    private fun EditText?.onTextChanged(changeField: (String)->Unit){
        this?.addTextChangedListener {
            changeField(it.toString())
            viewModel.sendIntent(LoginIntent.OnDataChanged(loginData))
        }
    }

    private fun updateFieldsTextData(loginData: LoginData){
        with(binding){
            etEmail.updateFieldData(loginData.email)
            etPassword.updateFieldData(loginData.password)
        }
    }

    private fun EditText.updateFieldData(newFieldData: String){
        if(this.text?.toString() != newFieldData) this.setText(newFieldData)
    }

    private fun login(){
        Log.d("testing login", "success")
    }

    //Error on invalid input or firebase request error
    private fun displayError(e: Exception){
        Log.d("testing error", e.message ?: "unknown error")
    }

    override fun render(state: LoginState) {
        when(state){
            is LoginState.CurrentLoginData -> updateFieldsTextData(state.data)
        }
    }

    override fun processAction(action: LoginAction) {
        when (action) {
            LoginAction.OpenRegisterScreen -> router?.newRootScreen(RegisterScreen())
            LoginAction.SuccessLogin -> login()
            is LoginAction.LoginError -> displayError(action.error)
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() = LoginFragment()
    }
}