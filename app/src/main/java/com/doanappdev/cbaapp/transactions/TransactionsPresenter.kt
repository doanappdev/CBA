package com.doanappdev.cbaapp.transactions

import com.doanappdev.cbaapp.base.ViewItem
import com.doanappdev.cbaapp.models.*
import com.doanappdev.cbaapp.repository.TransactionRepository
import com.google.gson.Gson
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.plusAssign
import org.jetbrains.anko.info

class TransactionsPresenter constructor(val repository: TransactionRepository) : TransactionsContract.Presenter {

    override lateinit var view: TransactionsContract.View
    private val recyclerViewItems = mutableListOf<ViewItem>()
    private val disposables = CompositeDisposable()

    override fun attach(view: TransactionsContract.View) {
        this.view = view
    }

    /**
     * Note: when contacting URL with retrofit2 error occurred.
     *       message: "Unable to resolve host "www.dropbox.com": No address associated with hostname"
     *       due to time constraint did not have time to resolve issue (I believe issue is related to
     *       dropbox was not an endpoint that served json as a response but as a file, so I needed to
     *       change how I downloaded the file.
     *
     *       This is an example of how json would be parsed using retrofit2
     */
    override fun subscribe() {
        disposables += repository.getTransactions()
                .subscribe( {
                    val account = it.account
                    val transactions = it.transactions
                    val atms = it.atms
                    info { "accountName : ${account.name}"}
                    transactions.map { info { "id : ${it.id}" } }
                    atms.map { info { "address : ${it.address}" } }
                    }, {
                        // handle connections errors
                        info { it.message }
                    }
                )
    }

    override fun parseJson() {
        val gson = Gson()
        val transactionResponse = gson.fromJson(repository.getJson(), TransactionsResponse::class.java)
        createRecyclerViewItems(transactionResponse)
    }

    fun createRecyclerViewItems(transactionResponse: TransactionsResponse) {
        transactionResponse.let {
            val account = it.account
            val transactions = it.transactions
            val pending = it.pending
            val atms = it.atms

            // always add account object first as it displays at the top of recycler view
            recyclerViewItems.add(AccountViewItem(account))

            transactions.map {
                recyclerViewItems.add(TransactionViewItem(it))
            }

            pending.map {
                it.type = "pending"
                recyclerViewItems.add(PendingViewItem(it))
            }
        }
    }

    override fun getViewItems() = recyclerViewItems

}
