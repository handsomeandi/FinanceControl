package com.example.financecontrol.di

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import com.example.financecontrol.config.Constants
import com.github.terrakok.cicerone.Cicerone
import com.github.terrakok.cicerone.Router
import com.github.terrakok.cicerone.androidx.AppNavigator
import org.koin.core.qualifier.named
import org.koin.dsl.module


//TODO: make scoped navigation(local and global)
val navigationModule = module {
    scope(named(Constants.GLOBAL_SCOPE_NAME)) {
        fun getRouter(cicerone: Cicerone<Router>) = cicerone.router
        fun getNavigationHolder(cicerone: Cicerone<Router>) = cicerone.getNavigatorHolder()

        scoped {
            Cicerone.create()
        }
        scoped {
            getRouter(get())
        }
        scoped {
            getNavigationHolder(get())
        }
        scoped { (activity: AppCompatActivity, containerId: Int, fragmentManager: FragmentManager) ->
            AppNavigator(activity, containerId, fragmentManager)
        }

    }
    scope(named(Constants.GLOBAL_FLOW_SCOPE_NAME)) {
        fun getRouter(cicerone: Cicerone<Router>) = cicerone.router
        fun getNavigationHolder(cicerone: Cicerone<Router>) = cicerone.getNavigatorHolder()

        scoped {
            Cicerone.create()
        }
        scoped {
            getRouter(get())
        }
        scoped {
            getNavigationHolder(get())
        }
        scoped { (activity: AppCompatActivity, containerId: Int, fragmentManager: FragmentManager) ->
            AppNavigator(activity, containerId, fragmentManager)
        }
    }

}
