package com.example.financecontrol.presentation.auth.login

import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.financecontrol.R
import com.example.financecontrol.databinding.FragmentLoginBinding
import com.example.financecontrol.presentation.base.BaseFragment
import com.example.financecontrol.presentation.navigation.Screens


class LoginFragment : BaseFragment<FragmentLoginBinding>(R.layout.fragment_login) {
    override val binding: FragmentLoginBinding by viewBinding()

    override fun onStart() {
        super.onStart()
        binding.btnRegister.setOnClickListener {
            router?.navigateTo(Screens.RegisterScreen())
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() = LoginFragment()
    }
}