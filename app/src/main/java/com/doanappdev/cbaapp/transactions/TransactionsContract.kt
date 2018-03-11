package com.doanappdev.cbaapp.transactions

import com.doanappdev.cbaapp.base.BaseContract
import com.doanappdev.cbaapp.base.ViewItem

class TransactionsContract {
    interface View : BaseContract.View {
        fun setAdapter(items: List<ViewItem>)
    }

    interface Presenter : BaseContract.Presenter<View> {
        fun parseJson()
        fun getViewItems() : List<ViewItem>
    }
}
