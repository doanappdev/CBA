package com.doanappdev.cbaapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.doanappdev.cbaapp.base.ViewItem
import com.doanappdev.cbaapp.transactions.TransactionsAdapter
import com.doanappdev.cbaapp.models.TransactionItem
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView.apply {
            adapter = TransactionsAdapter(testData())
        }
    }

    private fun testData() : List<ViewItem> {
        return List(30, { i ->
            TransactionItem((i * i).toString())
        })
    }

}
