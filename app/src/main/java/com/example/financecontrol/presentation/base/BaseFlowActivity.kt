package com.example.financecontrol.presentation.base

import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding
import com.github.terrakok.cicerone.NavigatorHolder
import com.github.terrakok.cicerone.Router
import com.github.terrakok.cicerone.androidx.AppNavigator

abstract class BaseFlowActivity<VB: ViewBinding>(@LayoutRes contentLayoutId: Int): AppCompatActivity(contentLayoutId), ScreenFlow {
    abstract val binding: VB
    abstract val router: Router

    override fun onBackPressed() {
        (supportFragmentManager.findFragmentById(containerId) as? BackHandler)?.handleBack() ?: super.onBackPressed()
    }

    override fun onResume() {
        super.onResume()
        navigatorHolder.setNavigator(navigator)
    }

    override fun onPause() {
        super.onPause()
        navigatorHolder.removeNavigator()
    }
}