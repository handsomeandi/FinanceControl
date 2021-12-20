package com.example.financecontrol.presentation.base

import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import com.github.terrakok.cicerone.Router

//TODO: implement single time events(navigation, toasts etc.)
abstract class BaseFragment<VB : ViewBinding, S: State, A:ViewAction, I:ViewIntent, VM:BaseViewModel<S,I,A>>(@LayoutRes layout: Int) : Fragment(layout),
    BackHandler {
    abstract val binding: VB
    abstract val viewModel: VM

    open val router: Router? by lazy {
        (parentFragment as? BaseFlowFragment<*,*,*,*,*>)?.router
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.state.observe(this){
            render(it)
        }
    }

    override fun handleBack() {
        router?.exit()
    }

    fun dispatchIntent(intent: I){
        viewModel.handleIntent(intent)
    }

    abstract fun render(state: S)
}