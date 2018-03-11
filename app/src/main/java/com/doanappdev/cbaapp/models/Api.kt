package com.doanappdev.cbaapp.models

import com.doanappdev.cbaapp.base.ViewItem

val ACCOUNT_INFO =  0
val PENDING = 1

data class Transaction(
        val id: String,
        val date: String,
        val description: String,
        val amount: Double
)

data class AccountInfo(
    val accountName: String,
    val accountNumber: String,
    val available: Double,
    val balance: Double
)

data class ATM(
    val id: String,
    val name: String,
    val address: String,
    val location: String,
    val lat: Float,
    val lng: Float
)


data class AccountInfoItem(val balance: String) : ViewItem {
    override fun getViewType() = ACCOUNT_INFO
}

data class TransactionItem(val title: String) : ViewItem {
    override fun getViewType() = PENDING
}


