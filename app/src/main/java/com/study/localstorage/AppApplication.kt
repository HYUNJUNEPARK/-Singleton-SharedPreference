package com.study.localstorage

import android.app.Application
import timber.log.Timber

class AppApplication : Application() {
    companion object {
        private lateinit var appApplication: AppApplication
    }

    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())
        appApplication = this@AppApplication
    }
}