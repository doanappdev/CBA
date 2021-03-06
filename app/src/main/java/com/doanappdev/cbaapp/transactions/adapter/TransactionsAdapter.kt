package com.doanappdev.cbaapp.transactions.adapter

import android.support.v4.util.SparseArrayCompat
import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import com.doanappdev.cbaapp.base.ViewItem
import com.doanappdev.cbaapp.base.ViewTypeDelegateAdapter
import com.doanappdev.cbaapp.models.ACCOUNT_TYPE
import com.doanappdev.cbaapp.models.PENDING_TYPE
import com.doanappdev.cbaapp.models.TRANSACTIION_TYPE

class TransactionsAdapter(private val viewItems: List<ViewItem>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var delegateAdapters = SparseArrayCompat<ViewTypeDelegateAdapter>()

    init {
        delegateAdapters.put(ACCOUNT_TYPE, AccountInfoDelegateAdapter())
        delegateAdapters.put(TRANSACTIION_TYPE, TransactionsDelegateAdapter())
        delegateAdapters.put(PENDING_TYPE, PendingDelegateAdapter())
    }

    override fun getItemCount(): Int = viewItems.count()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = delegateAdapters.get(viewType).onCreateViewHolder(parent)

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        delegateAdapters.get(getItemViewType(position)).onBindViewHolder(holder, viewItems[position])
    }

    override fun getItemViewType(position: Int) = viewItems[position].getViewType()
}
