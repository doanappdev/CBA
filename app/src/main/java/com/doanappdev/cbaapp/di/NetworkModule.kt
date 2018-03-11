package com.doanappdev.cbaapp.di

import com.doanappdev.cbaapp.data.CBAService
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class NetworkModule {

    @[Provides Singleton]
    fun provideRetrofitBuilder() : Retrofit.Builder =
         Retrofit.Builder()
                 .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                 .addConverterFactory(GsonConverterFactory.create())

    @[Provides Singleton]
    fun provideCBAService(builder: Retrofit.Builder) : CBAService = builder
//            .baseUrl("https://www.dropbox.com/s/tewg9b71x0wrou9/")
            .baseUrl("https://www.dropbox.com/")
            .build()
            .create(CBAService::class.java)

}
