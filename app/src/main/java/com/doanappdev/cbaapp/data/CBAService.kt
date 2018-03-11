package com.doanappdev.cbaapp.data

import com.doanappdev.cbaapp.models.TransactionsResponse
import io.reactivex.Observable
import retrofit2.http.GET
import okhttp3.ResponseBody
import retrofit2.Call


interface CBAService {

    @GET("s/tewg9b71x0wrou9/data.json?dl=1")
    fun getTransactions() : Observable<TransactionsResponse>

    @GET("s/tewg9b71x0wrou9/data.json?dl=1")
    fun downloadFileWithFixedUrl(): Call<ResponseBody>
}