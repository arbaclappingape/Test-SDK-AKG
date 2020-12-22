package com.arbaelbarca.testsdkakg

import android.app.Application
import com.orhanobut.hawk.Hawk

class SdkApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        Hawk.init(this)
                .build()

    }
}