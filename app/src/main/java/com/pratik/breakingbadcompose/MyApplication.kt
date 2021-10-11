package com.pratik.breakingbadcompose

import android.app.Application
import dagger.hilt.android.HiltAndroidApp


@HiltAndroidApp
class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()

//        val moduleList = listOf(
//            characterModule, networkModule
//        )
//        startKoin {
//            androidContext(this@MyApplication)
//            printLogger()
//            modules(moduleList)
//        }

    }
}