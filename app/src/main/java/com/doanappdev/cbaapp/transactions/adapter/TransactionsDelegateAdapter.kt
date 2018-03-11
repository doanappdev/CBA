package com.doanappdev.cbaapp.transactions.adapter

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import com.doanappdev.cbaapp.base.ViewItem
import com.doanappdev.cbaapp.base.ViewTypeDelegateAdapter
import com.doanappdev.cbaapp.base.inflate
import com.doanappdev.cbaapp.models.TransactionViewItem
import com.doanappdev.cbaapp.R
import com.doanappdev.cbaapp.setTextWithHtmlorString
import kotlinx.android.synthetic.main.item_transaction.view.*
import kotlinx.android.synthetic.main.item_header_date.view.*

class TransactionsDelegateAdapter : ViewTypeDelegateAdapter {

    override fun onCreateViewHolder(parent: ViewGroup): RecyclerView.ViewHolder {
        return TransactionsViewHolder(parent)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, item: ViewItem) {
        holder as TransactionsViewHolder
        holder.bind(item as TransactionViewItem)
    }

    inner class TransactionsViewHolder(parent: ViewGroup) : RecyclerView.ViewHolder(parent.inflate(R.layout.item_transaction)) {
        fun bind(item: TransactionViewItem) = with(itemView) {
            date.text = item.transaction.effectiveDate
            daysAgo.text = context.getString(R.string.days_ago).format(item.transaction.daysAgo)
            item.transaction.description.setTextWithHtmlorString(descOne)
            amountOne.text = item.transaction.amount.toString()
        }
    }
}
