package com.example.financecontrol.navigation

import com.example.financecontrol.presentation.auth.AuthFlowFragment
import com.example.financecontrol.presentation.auth.login.LoginFragment
import com.example.financecontrol.presentation.auth.register.RegisterFragment
import com.github.terrakok.cicerone.androidx.FragmentScreen

object Screens {
    fun AuthFlowScreen() = FragmentScreen {
        AuthFlowFragment.newInstance()
    }

    fun RegisterScreen() = FragmentScreen {
        RegisterFragment.newInstance()
    }

    fun LoginScreen() = FragmentScreen {
        LoginFragment.newInstance()
    }
}