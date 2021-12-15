package com.example.financecontrol.presentation.base

import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import com.example.financecontrol.R
import com.github.terrakok.cicerone.NavigatorHolder
import com.github.terrakok.cicerone.Router
import com.github.terrakok.cicerone.androidx.AppNavigator
import org.koin.core.parameter.parametersOf

abstract class BaseFlowFragment <VB : ViewBinding>(@LayoutRes layout: Int) : Fragment(layout),ScreenFlow, BackHandler {
    abstract val binding: VB

    override fun onResume() {
        super.onResume()
        navigatorHolder.setNavigator(navigator)
    }

    override fun onPause() {
        super.onPause()
        navigatorHolder.removeNavigator()
    }

    override fun handleBack() {
        (childFragmentManager.findFragmentById(containerId) as? BackHandler)?.handleBack() ?: router.exit()
    }
}