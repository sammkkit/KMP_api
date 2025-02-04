package org.example.assignment

import android.app.Application
import org.example.assignment.di.initKoin

class MyApp:Application() {
    override fun onCreate() {
        super.onCreate()
        initKoin()
    }
}