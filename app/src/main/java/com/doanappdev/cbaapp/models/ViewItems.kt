package com.doanappdev.cbaapp.models

import com.doanappdev.cbaapp.base.ViewItem

val ACCOUNT_TYPE =  0
val TRANSACTIION_TYPE = 1
val PENDING_TYPE = 2
val ATM_TYPE = 3

data class AccountViewItem(val accountInfo: AccountInfo) : ViewItem {
    override fun getViewType() = ACCOUNT_TYPE
}

data class TransactionViewItem(val transaction: Transaction) : ViewItem {
    override fun getViewType() = TRANSACTIION_TYPE
}

data class PendingViewItem(val transaction: Transaction) : ViewItem {
    override fun getViewType() = PENDING_TYPE
}

data class AtmViewItem(val atm: ATM) : ViewItem {
    override fun getViewType() = ATM_TYPE
}
