package com.doanappdev.cbaapp.transactions.adapter

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import com.doanappdev.cbaapp.base.ViewItem
import com.doanappdev.cbaapp.base.ViewTypeDelegateAdapter
import com.doanappdev.cbaapp.base.inflate
import com.doanappdev.cbaapp.R
import com.doanappdev.cbaapp.setTextWithHtmlorString
import com.doanappdev.cbaapp.models.PendingViewItem
import kotlinx.android.synthetic.main.item_header_date.view.*
import kotlinx.android.synthetic.main.item_pending.view.*

class PendingDelegateAdapter : ViewTypeDelegateAdapter {

    override fun onCreateViewHolder(parent: ViewGroup): RecyclerView.ViewHolder {
        return PendingViewHolder(parent)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, item: ViewItem) {
        holder as PendingViewHolder
        holder.bind(item as PendingViewItem)
    }

    inner class PendingViewHolder(parent: ViewGroup) : RecyclerView.ViewHolder(parent.inflate(R.layout.item_pending)) {
        fun bind(item: PendingViewItem) = with(itemView) {

            date.text = item.transaction.effectiveDate
            daysAgo.text = context.getString(R.string.days_ago).format(item.transaction.daysAgo)


//            item.transaction.description.apply {
//                when(this.contains("<")) {
//                    true -> desc.text = Html.fromHtml(this)
//                    else -> desc.text = this
//                }
//            }

            item.transaction.description.setTextWithHtmlorString(desc)

            amount.text = item.transaction.amount.toString()
        }
    }
}
