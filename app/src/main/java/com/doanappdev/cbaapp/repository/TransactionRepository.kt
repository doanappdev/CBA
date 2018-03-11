package com.doanappdev.cbaapp.repository

import com.doanappdev.cbaapp.data.CBAService
import com.doanappdev.cbaapp.models.TransactionsResponse
import io.reactivex.Observable
import okhttp3.ResponseBody
import retrofit2.Call

interface TransactionRepository {
    fun getTransactions() : Observable<TransactionsResponse>
    fun downloadFileWithFixedUrl(): Call<ResponseBody>
    fun getJson() : String
}
