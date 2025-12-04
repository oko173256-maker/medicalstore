package com.medicalstore.app

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import timber.log.Timber

@HiltAndroidApp
class MedicalStoreApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        
        // Initialize Timber for logging
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
        
        // Initialize other application components
        initializeAppComponents()
    }

    private fun initializeAppComponents() {
        // Initialize analytics, crash reporting, etc.
        Timber.d("MedicalStoreApplication initialized")
    }
}
