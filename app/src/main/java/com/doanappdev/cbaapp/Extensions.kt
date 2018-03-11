package com.doanappdev.cbaapp

import android.text.Html
import android.widget.TextView

fun String.setTextWithHtmlorString(textView: TextView) {
    when(this.contains("<")) {
        true -> textView.text = Html.fromHtml(this)
        else -> textView.text = this
    }
}