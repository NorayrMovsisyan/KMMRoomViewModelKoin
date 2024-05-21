package org.example.kmmsharedroom

import android.app.Application
import koin.KoinInitializer

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        KoinInitializer(applicationContext).init()
    }
}