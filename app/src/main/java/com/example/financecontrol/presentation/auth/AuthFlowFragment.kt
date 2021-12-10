package com.example.financecontrol.presentation.auth

import android.os.Bundle
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.financecontrol.R
import com.example.financecontrol.config.Constants
import com.example.financecontrol.databinding.FragmentAuthFlowBinding
import com.example.financecontrol.presentation.base.BaseFragment
import com.github.terrakok.cicerone.NavigatorHolder
import com.github.terrakok.cicerone.Router
import com.github.terrakok.cicerone.androidx.AppNavigator
import org.koin.android.ext.android.getKoin
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.component.getScopeId
import org.koin.core.parameter.parametersOf
import org.koin.core.qualifier.named

//TODO: Shared ViewModel that observes events on the child screens and navigates through them
class AuthFlowFragment : BaseFragment<FragmentAuthFlowBinding>(R.layout.fragment_auth_flow) {
    override val binding: FragmentAuthFlowBinding by viewBinding()
    private val scope = getKoin().createScope(getScopeId(), named(Constants.GLOBAL_FLOW_SCOPE_NAME))
    private val navigatorHolder: NavigatorHolder by scope.inject()
    private val router: Router by scope.inject()
    private val viewModel: AuthFlowViewModel by viewModel {
        parametersOf(router)
    }
    private val navigator: AppNavigator by scope.inject {
        parametersOf(this, R.id.fcvAuth, childFragmentManager)
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
    companion object {
        @JvmStatic
        fun newInstance() = AuthFlowFragment()
    }
}