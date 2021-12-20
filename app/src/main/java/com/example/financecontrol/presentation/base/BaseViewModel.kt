package com.example.financecontrol.presentation.base

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

abstract class BaseViewModel<S : State, I:ViewIntent, A: ViewAction> : ViewModel() {
    protected val mState: MutableLiveData<S> = MutableLiveData()
    val state: LiveData<S>
        get() = mState

    fun handleIntent(intent: I){
        handleAction(intentToAction(intent))
    }

    protected abstract fun intentToAction(intent: I): A

    protected abstract fun handleAction(action: A)

}