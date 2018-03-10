package com.doanappdev.cbaapp.transactions

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import com.doanappdev.cbaapp.base.ViewItem
import com.doanappdev.cbaapp.base.ViewTypeDelegateAdapter
import com.doanappdev.cbaapp.base.inflate
import com.doanappdev.cbaapp.models.TransactionItem
import com.doanappdev.cbaapp.R
import kotlinx.android.synthetic.main.item_pending.view.*

class TransactionsDelegateAdapter : ViewTypeDelegateAdapter {

    override fun onCreateViewHolder(parent: ViewGroup): RecyclerView.ViewHolder {
        return TransactionsViewHolder(parent)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, item: ViewItem) {
        holder as TransactionsViewHolder
        holder.bind(item as TransactionItem)
    }

    inner class TransactionsViewHolder(parent: ViewGroup) : RecyclerView.ViewHolder(parent.inflate(R.layout.item_pending)) {
        fun bind(item: TransactionItem) = with(itemView) {
            title.text = item.title
        }
    }
}
