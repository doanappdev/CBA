package com.doanappdev.cbaapp

import android.app.Application
import com.doanappdev.cbaapp.di.AppModule
import com.doanappdev.cbaapp.di.ApplicationComponent
import com.doanappdev.cbaapp.di.DaggerApplicationComponent
import com.doanappdev.cbaapp.di.NetworkModule

class CBAApp : Application() {
    companion object {
        lateinit var appComponent: ApplicationComponent
    }

    //@Inject lateinit var locationManager: LocationManager

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerApplicationComponent.builder()
                .application(this)
                .appModule(AppModule(this))
                .networkModule(NetworkModule())
                .build()

        // if we want to inject object into this class uncomment this
        //appComponent.inject(this)
    }
}
