package com.example.financecontrol

import android.app.Application
import com.example.financecontrol.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.GlobalContext.startKoin

class MainApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        // Start Koin
        startKoin {
            androidContext(this@MainApplication)
            modules(appModule)
        }
    }
}