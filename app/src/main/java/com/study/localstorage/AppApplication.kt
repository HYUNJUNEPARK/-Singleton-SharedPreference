package com.study.localstorage

import android.app.Application
import com.study.localstorage.datastore.PreferenceDatastoreEx
import timber.log.Timber

class AppApplication : Application() {
    private lateinit var dataStore : PreferenceDatastoreEx

    companion object {
        private lateinit var appApplication: AppApplication
        fun getInstance() : AppApplication = appApplication
    }

    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())
        appApplication = this@AppApplication
        dataStore = PreferenceDatastoreEx(this@AppApplication)
    }

    fun getDataStore(): PreferenceDatastoreEx = dataStore
}