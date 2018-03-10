package com.doanappdev.cbaapp.base

import org.jetbrains.anko.AnkoLogger

interface BaseContract {
    interface View {
        //val disposables: CompositeDisposables
    }

    interface Presenter<T : View> : AnkoLogger {
        fun attachView(view: T)
        fun subscribe()
    }
}
