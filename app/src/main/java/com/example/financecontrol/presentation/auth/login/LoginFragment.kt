package com.example.financecontrol.presentation.auth.login

import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.financecontrol.R
import com.example.financecontrol.config.AppExt.setSpannableString
import com.example.financecontrol.databinding.FragmentLoginBinding
import com.example.financecontrol.presentation.base.BaseFragment
import com.example.financecontrol.presentation.base.State
import com.example.financecontrol.presentation.base.ViewAction
import com.example.financecontrol.presentation.base.ViewIntent
import com.example.financecontrol.presentation.navigation.Screens.RegisterScreen

sealed class LoginState : State

sealed class LoginAction : ViewAction {
    object OpenRegisterScreen : LoginAction()
}

sealed class LoginIntent : ViewIntent {
    object OpenRegisterScreen : LoginIntent()
}


class LoginFragment :
    BaseFragment<FragmentLoginBinding, LoginState, LoginAction, LoginIntent, LoginViewModel>(R.layout.fragment_login) {
    override val binding: FragmentLoginBinding by viewBinding()
    override val viewModel: LoginViewModel by viewModels()

    override fun onStart() {
        super.onStart()
        with(binding) {
            tvSignUp.setSpannableString(tvSignUp.text.toString(), R.color.blue, 23 to 30) {
                dispatchIntent(LoginIntent.OpenRegisterScreen)
            }
        }
    }

    override fun render(state: LoginState) {
    }

    override fun processAction(action: LoginAction) {
        when (action) {
            LoginAction.OpenRegisterScreen -> router?.navigateTo(RegisterScreen())
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() = LoginFragment()
    }
}