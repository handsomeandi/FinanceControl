package com.example.financecontrol.presentation.auth

import android.os.Bundle
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.financecontrol.R
import com.example.financecontrol.config.Constants
import com.example.financecontrol.databinding.FragmentAuthFlowBinding
import com.example.financecontrol.presentation.base.BaseFlowFragment
import com.example.financecontrol.presentation.navigation.Screens
import com.github.terrakok.cicerone.NavigatorHolder
import com.github.terrakok.cicerone.Router
import com.github.terrakok.cicerone.androidx.AppNavigator
import org.koin.android.ext.android.getKoin
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.component.getScopeId
import org.koin.core.parameter.parametersOf
import org.koin.core.qualifier.named

//TODO: Shared ViewModel that observes events on the child screens and navigates through them
class AuthFlowFragment : BaseFlowFragment<FragmentAuthFlowBinding>(R.layout.fragment_auth_flow) {
    override val binding: FragmentAuthFlowBinding by viewBinding()
    private val scope = getKoin().createScope(getScopeId(), named(Constants.GLOBAL_FLOW_SCOPE_NAME))
    override val navigatorHolder: NavigatorHolder by scope.inject()
    override val router: Router by scope.inject()
    override val containerId: Int = R.id.fcvAuth
    override val navigator: AppNavigator by scope.inject {
        parametersOf(activity, containerId, childFragmentManager)
    }
    private val viewModel: AuthFlowViewModel by viewModel {
        parametersOf(router)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        router.newRootScreen(Screens.RegisterScreen())
    }

    override fun onDestroy() {
        super.onDestroy()
        scope.close()
    }

    companion object {
        @JvmStatic
        fun newInstance() = AuthFlowFragment()
    }
}