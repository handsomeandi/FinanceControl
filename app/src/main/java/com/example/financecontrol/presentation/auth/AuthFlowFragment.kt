package com.example.financecontrol.presentation.auth

import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.financecontrol.R
import com.example.financecontrol.databinding.FragmentAuthFlowBinding
import com.example.financecontrol.presentation.base.BaseFragment


class AuthFlowFragment : BaseFragment<FragmentAuthFlowBinding>(R.layout.fragment_auth_flow) {
    override val binding: FragmentAuthFlowBinding by viewBinding()

    companion object {
        @JvmStatic
        fun newInstance() = AuthFlowFragment()
    }
}