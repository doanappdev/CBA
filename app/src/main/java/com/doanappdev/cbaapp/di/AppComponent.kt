package com.doanappdev.cbaapp.di

import com.doanappdev.cbaapp.CBAApp
import com.doanappdev.cbaapp.data.CBAService
import com.doanappdev.cbaapp.transactions.TransactionsActivity
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class, NetworkModule::class])
interface ApplicationComponent {
    fun inject(mainActivity: TransactionsActivity)


    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: CBAApp) : Builder
        fun appModule(appModule: AppModule) : Builder
        fun networkModule(networkModule: NetworkModule) : Builder
        fun build() : ApplicationComponent
    }

    //fun getCBAService() : CBAService
}
