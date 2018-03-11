package com.doanappdev.cbaapp.repository

import android.util.Log
import com.doanappdev.cbaapp.data.CBAService
import com.doanappdev.cbaapp.models.TransactionsResponse
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class TransactionRepositoryImpl(private val service: CBAService) : TransactionRepository {

    val TAG = TransactionRepositoryImpl::class.java.simpleName

    override fun getTransactions(): Observable<TransactionsResponse> {
        return service.getTransactions()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
    }

    override fun getJson(): String {
        return "{\n" +
                "\t\"account\" : {\n" +
                "\t\t\"accountName\": \"Complete Access\",\n" +
                "\t\t\"accountNumber\": \"062005 1709 5888\",\n" +
                "\t\t\"available\": 226.76,\n" +
                "\t\t\"balance\": 246.76\n" +
                "\t},\n" +
                "\t\"transactions\": [{\n" +
                "\t\t\"id\": \"44e5b2bc484331ea24afd85ecfb212c8\",\n" +
                "\t\t\"effectiveDate\": \"20/07/2017\",\n" +
                "\t\t\"description\": \"Kaching TFR from JOHN CITIZEN<br/>xmas donation\",\n" +
                "\t\t\"amount\": 12.00\n" +
                "\t}, {\n" +
                "\t\t\"id\": \"1506aeeb8c3a699b1e3c87db03156428\",\n" +
                "\t\t\"effectiveDate\": \"20/07/2017\",\n" +
                "\t\t\"description\": \"Wdl ATM CBA ATM CIRCULAR QUAY STATION NSW 221092 AUS\",\n" +
                "\t\t\"amount\": -200.00,\n" +
                "\t\t\"atmId\": \"129382\"\n" +
                "\t}, {\n" +
                "\t\t\"id\": \"9a899bfd978511e9605774e1d5222b67\",\n" +
                "\t\t\"description\": \"Savings\",\n" +
                "\t\t\"effectiveDate\": \"19/07/2017\",\n" +
                "\t\t\"amount\": 10.00\n" +
                "\t}, {\n" +
                "\t\t\"id\": \"1a6c48627cecaa2388b702fa33d751ff\",\n" +
                "\t\t\"description\": \"PTAG COCA COLA AMATI\",\n" +
                "\t\t\"effectiveDate\": \"12/07/2017\",\n" +
                "\t\t\"amount\": -2.20\n" +
                "\t}, {\n" +
                "\t\t\"id\": \"7ecc19e1a0be36ba2c6f05d06b5d3058\",\n" +
                "\t\t\"description\": \"Wdl ATM CBA ATM TOWN HALL SQUARE NSW 253432 AUS\",\n" +
                "\t\t\"effectiveDate\": \"04/07/2017\",\n" +
                "\t\t\"amount\": -50.00,\n" +
                "\t\t\"atmId\": \"137483\"\n" +
                "\t}, {\n" +
                "\t\t\"id\": \"b71bf065b640217dad602f86ac047722\",\n" +
                "\t\t\"description\": \"BPAY - Telstra mobile\",\n" +
                "\t\t\"effectiveDate\": \"04/07/2017\",\n" +
                "\t\t\"amount\": -49.00\n" +
                "\t},{\n" +
                "\t\t\"id\": \"ef087651eb482bae4624478696f4ad4f\",\n" +
                "\t\t\"description\": \"Transfer from REBECCA SHAW<br/>Lorem ipsum\",\n" +
                "\t\t\"effectiveDate\": \"03/07/2017\",\n" +
                "\t\t\"amount\": 150.00\n" +
                "\t}, {\n" +
                "\t\t\"id\": \"8cd283d8b7bacc277f2bae5e26ce6d1e\",\n" +
                "\t\t\"description\": \"Savings\",\n" +
                "\t\t\"effectiveDate\": \"01/07/2017\",\n" +
                "\t\t\"amount\": 200.00\n" +
                "\t}, {\n" +
                "\t\t\"id\": \"04117d2d74f5331f3ee4955da27cca7a\",\n" +
                "\t\t\"effectiveDate\": \"28/06/2017\",\n" +
                "\t\t\"description\": \"Transfer - Saturday drinks\",\n" +
                "\t\t\"amount\": -100.00\n" +
                "\t}, {\n" +
                "\t\t\"id\": \"821ae63dbe0c573eff8b69d451fb21bc\",\n" +
                "\t\t\"effectiveDate\": \"21/06/2017\",\n" +
                "\t\t\"description\": \"Wdl ATM CBA ATM CIRCULAR QUAY STATION NSW 221092 AUS\",\n" +
                "\t\t\"amount\": -200.00,\n" +
                "\t\t\"atmId\": \"129382\"\n" +
                "\t}, {\n" +
                "\t\t\"id\": \"210ab9e731c9c36c2c38db15c28a8d1c\",\n" +
                "\t\t\"description\": \"Account fee\",\n" +
                "\t\t\"effectiveDate\": \"12/06/2017\",\n" +
                "\t\t\"amount\": -4.00\n" +
                "\t}, {\n" +
                "\t\t\"id\": \"d4fae4b45e689707e7dea506afc8c0e7\",\n" +
                "\t\t\"description\": \"TELSTRA CORP LTD BPAY 23796 1000006591234\",\n" +
                "\t\t\"effectiveDate\": \"4/06/2017\",\n" +
                "\t\t\"amount\": -89.00\n" +
                "\t}, {\n" +
                "\t\t\"id\": \"87f6f9d078c3bc5db5578f3b4add9470\",\n" +
                "\t\t\"description\": \"Credit Interest\",\n" +
                "\t\t\"effectiveDate\": \"3/06/2017\",\n" +
                "\t\t\"amount\": 0.02\n" +
                "\t}],\n" +
                "\t\"pending\" : [{\n" +
                "\t\t\"id\": \"e2eff6c2dafd909df8508f891b385d88\",\n" +
                "\t\t\"description\": \"WILSON PARKING SYDOBS SYDNEY NS AUS<br/>LAST 4 CARD DIGITS: 6901\",\n" +
                "\t\t\"effectiveDate\": \"22/05/2017\",\n" +
                "\t\t\"amount\": -12.00\n" +
                "\t},{\n" +
                "\t\t\"id\": \"901889f4f34f8ca18ac2f53d1fed346e\",\n" +
                "\t\t\"description\": \"CITYOFSYDNEYPARKINGTX SYDNEY, 1215<br/>LAST 4 CARD DIGITS: 6901\",\n" +
                "\t\t\"effectiveDate\": \"17/05/2017\",\n" +
                "\t\t\"amount\": -8.00\n" +
                "\t}],\n" +
                "\t\"atms\": [\n" +
                "\t\t{\n" +
                "\t\t\t\"id\": \"129382\",\n" +
                "\t\t\t\"name\": \"Circular Quay Station\",\n" +
                "\t\t\t\"address\": \"8 Alfred St, Sydney, NSW 2000\",\n" +
                "\t\t\t\"location\": {\n" +
                "\t\t\t\t\"lat\": -33.861382,\n" +
                "\t\t\t\t\"lng\": 151.210316\n" +
                "\t\t\t}\n" +
                "\t\t},\n" +
                "\t\t{\n" +
                "\t\t\t\"id\": \"137483\",\n" +
                "\t\t\t\"name\": \"Town Hall Square\",\n" +
                "\t\t\t\"address\": \"464-480 Kent St, Sydney, NSW 2000\",\n" +
                "\t\t\t\"location\": {\n" +
                "\t\t\t\t\"lat\": -33.873181,\n" +
                "\t\t\t\t\"lng\": 151.205389\n" +
                "\t\t\t}\n" +
                "\t\t}\n" +
                "    ]\n" +
                "}"
    }

    override fun downloadFileWithFixedUrl(): Call<ResponseBody> {
        val call = service.downloadFileWithFixedUrl()

        call.enqueue(object : Callback<ResponseBody> {
            override fun onResponse(call: Call<ResponseBody>, response: Response<ResponseBody>) {
                if (response.isSuccessful) {
                    Log.d(TAG, "server contacted and has file")
                    val responseBody = response.body()
                    Log.d(TAG, "responseBody : $responseBody")
                    //val writtenToDisk = writeResponseBodyToDisk(response.body())
                    //Log.d(TAG, "file download was a success? " + writtenToDisk)
                } else {
                    Log.d(TAG, "server contact failed")
                }
            }

            override  fun onFailure(call: Call<ResponseBody>, t: Throwable) {
                Log.e(TAG, "error")
            }
        })

        return call
    }
}