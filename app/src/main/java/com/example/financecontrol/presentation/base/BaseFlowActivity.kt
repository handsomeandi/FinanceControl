package com.example.financecontrol.presentation.base

import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import androidx.viewbinding.ViewBinding
import com.github.terrakok.cicerone.NavigatorHolder
import com.github.terrakok.cicerone.Router
import com.github.terrakok.cicerone.androidx.AppNavigator

abstract class BaseFlowActivity<VB: ViewBinding,S: State, I: ViewIntent, A: ViewAction, VM: BaseViewModel<S,I,A>>(@LayoutRes contentLayoutId: Int): AppCompatActivity(contentLayoutId), ScreenFlow {
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
    abstract val viewModel: VM

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.state.observe(this){
            render(it)
        }
        viewModel.actions.observe(this){
            processAction(it)
        }
    }

    fun dispatchIntent(intent: I){
        viewModel.sendIntent(intent)
    }

    abstract fun render(state: S)

    abstract fun processAction(action: A)
}