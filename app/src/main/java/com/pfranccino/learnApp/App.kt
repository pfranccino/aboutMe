package com.pfranccino.learnApp

import android.app.Application
import com.pfranccino.learnApp.util.AppDataBase

class App : Application() {

    override fun onCreate() {
        super.onCreate()

        AppDataBase.getAppDataBase(this)



    }
}