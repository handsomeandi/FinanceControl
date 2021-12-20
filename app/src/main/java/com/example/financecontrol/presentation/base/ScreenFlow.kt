package com.example.financecontrol.presentation.base

import com.github.terrakok.cicerone.NavigatorHolder
import com.github.terrakok.cicerone.Router
import com.github.terrakok.cicerone.androidx.AppNavigator

interface ScreenFlow {
    val navigatorHolder: NavigatorHolder
    val navigator: AppNavigator
    val containerId: Int
}