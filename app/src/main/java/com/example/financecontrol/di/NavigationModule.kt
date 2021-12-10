package com.example.financecontrol.di

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import com.github.terrakok.cicerone.Cicerone
import com.github.terrakok.cicerone.Router
import com.github.terrakok.cicerone.androidx.AppNavigator
import org.koin.dsl.module


//TODO: make scoped navigation(local and global)
val navigationModule = module {
    fun getRouter(cicerone: Cicerone<Router>) = cicerone.router
    fun getNavigationHolder(cicerone: Cicerone<Router>) = cicerone.getNavigatorHolder()

    single{
        Cicerone.create()
    }
    factory {
        getRouter(get())
    }
    factory{
        getNavigationHolder(get())
    }
    factory{ (activity: AppCompatActivity, containerId: Int, fragmentManager: FragmentManager) ->
        AppNavigator(activity, containerId,fragmentManager)
    }
}
