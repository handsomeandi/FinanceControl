package com.example.financecontrol.presentation.base

import androidx.annotation.LayoutRes
import androidx.viewbinding.ViewBinding

abstract class BaseFlowFragment <VB : ViewBinding, S: State, A: ViewAction, I: ViewIntent, VM:BaseViewModel<S,I,A>>(@LayoutRes layout: Int) : BaseFragment<VB, S, A, I, VM>(layout),ScreenFlow {
    override fun onResume() {
        super.onResume()
        navigatorHolder.setNavigator(navigator)
    }

    override fun onPause() {
        super.onPause()
        navigatorHolder.removeNavigator()
    }

    override fun handleBack() {
        (childFragmentManager.findFragmentById(containerId) as? BackHandler)?.handleBack() ?: router?.exit()
    }
}