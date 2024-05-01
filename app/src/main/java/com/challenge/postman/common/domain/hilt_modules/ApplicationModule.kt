package com.challenge.postman.common.domain.hilt_modules

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class ApplicationModule: Application() {
    override fun onCreate() {
        super.onCreate()
    }
}