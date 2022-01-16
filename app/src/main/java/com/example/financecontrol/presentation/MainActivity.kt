package com.example.financecontrol.presentation

import android.os.Bundle
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.financecontrol.R
import com.example.financecontrol.config.Constants
import com.example.financecontrol.databinding.ActivityMainBinding
import com.example.financecontrol.presentation.base.BaseFlowActivity
import com.example.financecontrol.presentation.base.State
import com.example.financecontrol.presentation.base.ViewAction
import com.example.financecontrol.presentation.base.ViewIntent
import com.example.financecontrol.presentation.navigation.Screens
import com.github.terrakok.cicerone.NavigatorHolder
import com.github.terrakok.cicerone.Router
import com.github.terrakok.cicerone.androidx.AppNavigator
import org.koin.android.ext.android.getKoin
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.component.getScopeId
import org.koin.core.parameter.parametersOf
import org.koin.core.qualifier.named

sealed class MainState : State

sealed class MainAction : ViewAction {
    object OpenAuthFlowScreen : MainAction()
}

sealed class MainIntent : ViewIntent {
    object OpenAuthFlowScreen : MainIntent()
}

class MainActivity :
    BaseFlowActivity<ActivityMainBinding, MainState, MainIntent, MainAction, MainActivityViewModel>(
        R.layout.activity_main
    ) {
    private val scope = getKoin().createScope(getScopeId(), named(Constants.GLOBAL_SCOPE_NAME))
    override val navigatorHolder: NavigatorHolder by scope.inject()
    override val router: Router by scope.inject()
    override val viewModel: MainActivityViewModel by viewModel {
        parametersOf(router)
    }
    override val containerId: Int = R.id.fcvActivity
    override val binding: ActivityMainBinding by viewBinding()
    override val navigator: AppNavigator by scope.inject {
        parametersOf(this, containerId, supportFragmentManager)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.sendIntent(MainIntent.OpenAuthFlowScreen)
    }

    override fun render(state: MainState) {

    }

    override fun processAction(action: MainAction) {
        when (action) {
            MainAction.OpenAuthFlowScreen -> router.navigateTo(Screens.AuthFlowScreen())
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        scope.close()
    }
}