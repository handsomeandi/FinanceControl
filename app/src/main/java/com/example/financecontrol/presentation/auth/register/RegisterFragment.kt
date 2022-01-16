package com.example.financecontrol.presentation.auth.register

import android.util.Log
import android.widget.EditText
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.financecontrol.R
import com.example.financecontrol.config.AppExt.setSpannableString
import com.example.financecontrol.databinding.FragmentRegisterBinding
import com.example.financecontrol.presentation.base.BaseFragment
import com.example.financecontrol.presentation.base.State
import com.example.financecontrol.presentation.base.ViewAction
import com.example.financecontrol.presentation.base.ViewIntent
import com.example.financecontrol.presentation.navigation.Screens.LoginScreen
import java.lang.Exception

sealed class RegisterState : State{
    class CurrentRegisterData(val data: RegisterData): RegisterState()
}

sealed class RegisterAction : ViewAction {
    object OpenLoginScreen : RegisterAction()
    object SuccessRegister : RegisterAction()
    class RegisterError(val error: Exception) : RegisterAction()
}

sealed class RegisterIntent : ViewIntent {
    object OnLoginPressed : RegisterIntent()
    class OnDataChanged(val data: RegisterData) : RegisterIntent()
    object OnRegisterPressed : RegisterIntent()
}

//TODO: (Login, Register screens): check user input, make firebase request, save username, handle error and success, navigate to main flow
class RegisterFragment :
    BaseFragment<FragmentRegisterBinding, RegisterState, RegisterAction, RegisterIntent, RegisterViewModel>(R.layout.fragment_register) {
    override val binding: FragmentRegisterBinding by viewBinding()

    override val viewModel: RegisterViewModel by viewModels()

    private val registerData: RegisterData = RegisterData()

    override fun onStart() {
        super.onStart()
        initListeners()
        with(binding) {
            tvSignIn.setSpannableString(tvSignIn.text.toString(), R.color.blue, 25 to 32) {
                dispatchIntent(RegisterIntent.OnLoginPressed)
            }
        }
    }

    private fun initListeners(){
        with(binding){
            etUsername.onTextChanged{
                registerData.username = it
            }
            etEmail.onTextChanged {
                registerData.email = it
            }
            etPassword.onTextChanged {
                registerData.password = it
            }
            etPasswordRepeat.onTextChanged {
                registerData.passwordRepeat = it
            }
            btnSignUp.setOnClickListener {
                viewModel.sendIntent(RegisterIntent.OnRegisterPressed)
            }
        }
    }

    private fun EditText?.onTextChanged(changeField: (String)->Unit){
        this?.addTextChangedListener {
            changeField(it.toString())
            viewModel.sendIntent(RegisterIntent.OnDataChanged(registerData))
        }
    }

    private fun updateFieldsTextData(registerData: RegisterData){
        with(binding){
            etUsername.updateFieldData(registerData.username)
            etEmail.updateFieldData(registerData.email)
            etPassword.updateFieldData(registerData.password)
            etPasswordRepeat.updateFieldData(registerData.passwordRepeat)
        }
    }

    private fun EditText.updateFieldData(newFieldData: String){
        if(this.text?.toString() != newFieldData) this.setText(newFieldData)
    }

    //Firebase Register request
    private fun register(){
        Log.d("testing", "success")
    }

    //Error on invalid input or firebase request error
    private fun displayError(e: Exception){
        Log.d("testing", e.message ?: "unknown error")
    }

    override fun render(state: RegisterState) {
        when(state){
            is RegisterState.CurrentRegisterData -> updateFieldsTextData(state.data)
        }
    }

    override fun processAction(action: RegisterAction) {
        when (action) {
            RegisterAction.OpenLoginScreen -> router?.navigateTo(LoginScreen())
            RegisterAction.SuccessRegister -> register()
            is RegisterAction.RegisterError -> displayError(action.error)
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() = RegisterFragment()
    }
}