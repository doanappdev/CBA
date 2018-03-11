package com.doanappdev.cbaapp.data

import io.reactivex.Observable
import retrofit2.http.GET

interface ApiEndpoints {

    @GET("data.json?dl=1")
    fun getTransactions() : Observable<String>
}