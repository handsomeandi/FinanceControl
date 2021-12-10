package com.example.financecontrol.presentation.auth.register

import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.financecontrol.R
import com.example.financecontrol.databinding.FragmentRegisterBinding
import com.example.financecontrol.presentation.base.BaseFragment


class RegisterFragment : BaseFragment<FragmentRegisterBinding>(R.layout.fragment_register) {
    override val binding: FragmentRegisterBinding by viewBinding()

    companion object {
        @JvmStatic
        fun newInstance() = RegisterFragment()
    }
}