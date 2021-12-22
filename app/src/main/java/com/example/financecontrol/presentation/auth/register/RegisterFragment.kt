package com.example.financecontrol.presentation.auth.register

import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.financecontrol.R
import com.example.financecontrol.databinding.FragmentRegisterBinding
import com.example.financecontrol.presentation.base.BaseFragment
import com.example.financecontrol.presentation.base.State
import com.example.financecontrol.presentation.base.ViewAction
import com.example.financecontrol.presentation.base.ViewIntent
import com.example.financecontrol.presentation.navigation.Screens

sealed class RegisterState: State

sealed class RegisterAction: ViewAction{
    object SomeAction: RegisterAction()
}

sealed class RegisterIntent: ViewIntent

class RegisterFragment : BaseFragment<FragmentRegisterBinding,RegisterState, RegisterAction, RegisterIntent, RegisterViewModel>(R.layout.fragment_register) {
    override val binding: FragmentRegisterBinding by viewBinding()

    override val viewModel: RegisterViewModel by viewModels()

    override fun onStart() {
        super.onStart()
        binding.btnLogin.setOnClickListener{
            router?.navigateTo(Screens.LoginScreen())
        }
    }

    override fun render(state: RegisterState) {
    }

    override fun processAction(action: RegisterAction) {

    }

    companion object {
        @JvmStatic
        fun newInstance() = RegisterFragment()
    }
}