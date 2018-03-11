package com.doanappdev.cbaapp.transactions

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.content.ContextCompat
import com.doanappdev.cbaapp.CBAApp
import com.doanappdev.cbaapp.R
import com.doanappdev.cbaapp.base.ViewItem
import com.doanappdev.cbaapp.models.AccountInfoItem
import com.doanappdev.cbaapp.transactions.adapter.TransactionsAdapter
import com.doanappdev.cbaapp.models.TransactionItem
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.info
import javax.inject.Inject

class TransactionActivity : AppCompatActivity(), TransactionContract.View, AnkoLogger {

    @Inject lateinit var 

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        CBAApp.appComponent.inject(this)

        toolbar.apply {
            title = "Account Details"
            navigationIcon = ContextCompat.getDrawable(context, R.drawable.ic_welcome_logo)
        }

        recyclerView.apply {
            adapter = TransactionsAdapter(testData())
        }


        val json = getString(R.string.json_transactions)
        info { "json: $json" }

    }

    private fun testData() : List<ViewItem> {
        return listOf(
                AccountInfoItem("1000"),
                TransactionItem("PENDING: PTAG Mount Street Sydney"),
                TransactionItem("PENDING: PTAG Mount Street Sydney"),
                TransactionItem("PENDING: PTAG Mount Street Sydney"),
                TransactionItem("PENDING: PTAG Mount Street Sydney"),
                TransactionItem("PENDING: PTAG Mount Street Sydney"),
                TransactionItem("PENDING: PTAG Mount Street Sydney"),
                TransactionItem("PENDING: PTAG Mount Street Sydney"),
                TransactionItem("PENDING: PTAG Mount Street Sydney"),
                TransactionItem("PENDING: PTAG Mount Street Sydney"),
                TransactionItem("PENDING: PTAG Mount Street Sydney"),
                TransactionItem("PENDING: PTAG Mount Street Sydney")
        )
    }

}
