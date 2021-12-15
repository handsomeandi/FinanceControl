package com.example.financecontrol.presentation.base

import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding

abstract class BaseFragment<VB : ViewBinding>(@LayoutRes layout: Int) : Fragment(layout),
    BackHandler {
    abstract val binding: VB

    protected val router by lazy {
        (parentFragment as? BaseFlowFragment<*>)?.router
    }

    override fun handleBack() {
        router?.exit()
    }
}