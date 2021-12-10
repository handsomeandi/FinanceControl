package com.example.financecontrol.presentation.auth.login

import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.financecontrol.R
import com.example.financecontrol.databinding.FragmentLoginBinding
import com.example.financecontrol.presentation.base.BaseFragment


class LoginFragment : BaseFragment<FragmentLoginBinding>(R.layout.fragment_login) {
    override val binding: FragmentLoginBinding by viewBinding()

    companion object {
        @JvmStatic
        fun newInstance() = LoginFragment()
    }
}