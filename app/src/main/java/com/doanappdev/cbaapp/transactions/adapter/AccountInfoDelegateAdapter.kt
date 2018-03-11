package com.doanappdev.cbaapp.transactions.adapter

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import com.doanappdev.cbaapp.R
import com.doanappdev.cbaapp.base.ViewItem
import com.doanappdev.cbaapp.base.ViewTypeDelegateAdapter
import com.doanappdev.cbaapp.base.inflate
import com.doanappdev.cbaapp.models.AccountViewItem
import kotlinx.android.synthetic.main.item_account_info.view.*

class AccountInfoDelegateAdapter : ViewTypeDelegateAdapter {

    override fun onCreateViewHolder(parent: ViewGroup): RecyclerView.ViewHolder {
        return AccountInfoViewHolder(parent)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, item: ViewItem) {
        holder as AccountInfoViewHolder
        holder.bind(item as AccountViewItem)
    }

    inner class AccountInfoViewHolder(parent: ViewGroup) : RecyclerView.ViewHolder(parent.inflate(R.layout.item_account_info)) {
        fun bind(item: AccountViewItem) = with(itemView) {
            val accountInfo = item.accountInfo
            accountName.text = accountInfo.name
            accountNumber.text = accountInfo.number
            funds.text = accountInfo.available.toString()
            balance.text = accountInfo.balance.toString()
        }
    }
}
