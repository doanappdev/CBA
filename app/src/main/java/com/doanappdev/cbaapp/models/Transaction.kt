package com.doanappdev.cbaapp.models

import com.doanappdev.cbaapp.base.ViewItem


val PENDING = 0

data class TransactionItem(val title: String) : ViewItem {
    override fun getViewType() = PENDING
}
