package com.example.financecontrol.presentation.base

import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding

abstract class BaseFragment<VB : ViewBinding>(@LayoutRes layout: Int) : Fragment(layout) {
    abstract val binding: VB
}