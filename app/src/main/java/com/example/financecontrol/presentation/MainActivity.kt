package com.example.financecontrol.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.financecontrol.R
import com.example.financecontrol.config.Constants
import com.example.financecontrol.databinding.ActivityMainBinding
import com.github.terrakok.cicerone.NavigatorHolder
import com.github.terrakok.cicerone.Router
import com.github.terrakok.cicerone.androidx.AppNavigator
import org.koin.android.ext.android.getKoin
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.component.getScopeId
import org.koin.core.parameter.parametersOf
import org.koin.core.qualifier.named

class MainActivity : AppCompatActivity(R.layout.activity_main) {
    private val scope = getKoin().createScope(getScopeId(), named(Constants.GLOBAL_SCOPE_NAME))
    private val navigatorHolder: NavigatorHolder by scope.inject()
    private val router: Router by scope.inject()
    private val viewModel: MainActivityViewModel by viewModel {
        parametersOf(router)
    }
    private val binding: ActivityMainBinding by viewBinding()
    private val navigator: AppNavigator by scope.inject {
        parametersOf(this, R.id.fcvActivity, supportFragmentManager)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.onStart()
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