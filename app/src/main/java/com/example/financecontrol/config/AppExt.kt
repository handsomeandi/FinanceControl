package com.example.financecontrol.config

import android.text.SpannableString
import android.text.Spanned
import android.text.TextPaint
import android.text.method.LinkMovementMethod
import android.text.style.ClickableSpan
import android.view.View
import android.widget.TextView
import androidx.core.content.ContextCompat
import com.example.financecontrol.MainApplication

object AppExt {
    fun TextView.setSpannableString(text: String, colorId: Int, indexes: Pair<Int, Int>, onClick: () -> Unit){
        val spanString = SpannableString(text)
        spanString.setSpan(object : ClickableSpan() {
            override fun onClick(widget: View) {
                onClick()
            }

            override fun updateDrawState(ds: TextPaint) {
                ds.color = ContextCompat.getColor(MainApplication.shared.applicationContext, colorId)
                ds.isUnderlineText = true
            }
        }, indexes.first, indexes.second, Spanned.SPAN_INCLUSIVE_INCLUSIVE)
        this.text = spanString
        this.movementMethod = LinkMovementMethod.getInstance()
    }
}