package com.example.financecontrol.presentation.auth.register

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

sealed class RegisterState : State

sealed class RegisterAction : ViewAction {
    object OpenLoginScreen : RegisterAction()
}

sealed class RegisterIntent : ViewIntent {
    object OpenLoginScreen : RegisterIntent()
}

//TODO: (Login, Register screens): check user input, make firebase request, save username, handle error and success, navigate to main flow
class RegisterFragment :
    BaseFragment<FragmentRegisterBinding, RegisterState, RegisterAction, RegisterIntent, RegisterViewModel>(R.layout.fragment_register) {
    override val binding: FragmentRegisterBinding by viewBinding()

    override val viewModel: RegisterViewModel by viewModels()

    override fun onStart() {
        super.onStart()
        with(binding) {
            tvSignIn.setSpannableString(tvSignIn.text.toString(), R.color.blue, 25 to 32) {
                dispatchIntent(RegisterIntent.OpenLoginScreen)
            }
        }
    }

    override fun render(state: RegisterState) {
    }

    override fun processAction(action: RegisterAction) {
        when (action) {
            RegisterAction.OpenLoginScreen -> router?.navigateTo(LoginScreen())
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() = RegisterFragment()
    }
}