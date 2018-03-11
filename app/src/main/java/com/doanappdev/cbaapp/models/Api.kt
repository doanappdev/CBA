package com.doanappdev.cbaapp.models

import android.util.Log
import com.google.gson.annotations.SerializedName
import java.text.SimpleDateFormat
import java.util.*

val SECOND_MILLISECONDS = 1000L
val MINUTE_MILLISECONDS = 60 * SECOND_MILLISECONDS
val HOUR_MILLISECONDS = 60 * MINUTE_MILLISECONDS
val DAY_MILLISECONDS = 24 * HOUR_MILLISECONDS

data class TransactionsResponse(
        val account: AccountInfo,
        val transactions: List<Transaction>,
        val pending: List<Transaction>,
        val atms: List<ATM>
)

data class AccountInfo(
        @SerializedName("accountName") val name: String,
        @SerializedName("accountNumber")val number: String,
        val available: Double,
        val balance: Double
)


data class Transaction(
        val id: String,
        val effectiveDate: String,
        val description: String,
        val amount: Double
) {
    // this is used a a marker to help if transaction is pending
    var type = "transaction"

    val daysAgo: Int
        get() {
            val formatter = SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH)
            val startDate = formatter.parse(effectiveDate)
            return getDaysDiff(startDate)
        }

    fun getDaysDiff(date: Date): Int {
        val cal = GregorianCalendar.getInstance()
        val todayDayOfYear = cal.get(Calendar.DAY_OF_YEAR)
        val todayYear = cal.get(Calendar.YEAR)

        cal.time = date
        val dayOfYear = cal.get(Calendar.DAY_OF_YEAR)
        val year = cal.get(Calendar.YEAR)

        if (todayYear == year) {
            return dayOfYear - todayDayOfYear
        } else {
            val diff = getCountDownMillisSeconds(date)
            return (diff / DAY_MILLISECONDS).toInt()
        }
    }

    fun getCountDownMillisSeconds(date: Date?) = when(date == null) {
        true -> 0
        else -> date!!.time - System.currentTimeMillis()
    }

}

//data class Pending(
//        override val id: String,
//        override val effectiveDate: String,
//        override val description: String,
//        override val amount: Double
//) : BaseTransaction(id, effectiveDate, description, amount)


data class ATM(
    val id: String,
    val name: String,
    val address: String,
    val location: Location
)

data class Location(
        val lat: Float,
        val lng: Float
)

//sealed class BaseTransaction(
//        open val id: String,
//        open val effectiveDate: String,
//        open val description: String,
//        open val amount: Double
//)