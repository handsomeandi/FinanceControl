package com.example.financecontrol.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import by.kirich1409.viewbindingdelegate.CreateMethod
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.financecontrol.R
import com.example.financecontrol.databinding.ActivityMainBinding
import com.github.terrakok.cicerone.NavigatorHolder
import com.github.terrakok.cicerone.Router
import com.github.terrakok.cicerone.androidx.AppNavigator
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf

class MainActivity : AppCompatActivity(R.layout.activity_main) {

    private val navigatorHolder: NavigatorHolder by inject()
    private val router: Router by inject()
    private val viewModel: MainActivityViewModel by viewModel{
        parametersOf(router)
    }
    private val binding: ActivityMainBinding by viewBinding()
    private val navigator: AppNavigator by inject{
        parametersOf(this, R.id.fcvActivity, supportFragmentManager)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onResume() {
        super.onResume()
        navigatorHolder.setNavigator(navigator)
        viewModel.onStart()

    }

    override fun onPause() {
        super.onPause()
        navigatorHolder.removeNavigator()
    }
}