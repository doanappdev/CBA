package com.doanappdev.cbaapp.transactions

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.content.ContextCompat
import com.doanappdev.cbaapp.CBAApp
import com.doanappdev.cbaapp.R
import com.doanappdev.cbaapp.base.ViewItem
import com.doanappdev.cbaapp.transactions.adapter.TransactionsAdapter
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.AnkoLogger
import javax.inject.Inject

class TransactionsActivity : AppCompatActivity(), TransactionsContract.View, AnkoLogger {

    @Inject lateinit var presenter: TransactionsContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        CBAApp.appComponent.inject(this)
        presenter.attach(this)
        //presenter.subscribe()
        presenter.parseJson()

        toolbar.apply {
            title = "Account Details"
            navigationIcon = ContextCompat.getDrawable(context, R.drawable.ic_welcome_logo)
        }

        recyclerView.apply {
            adapter = TransactionsAdapter(presenter.getViewItems())
        }
    }

    override fun setAdapter(items: List<ViewItem>) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
