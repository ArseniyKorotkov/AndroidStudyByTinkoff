package by.arsy.androidstudybytinkoff

import android.util.Log

class AnalyticsImpl(private val tag: String) : Analytics {
    override fun onShown() {
        Log.i(tag, "onShown")
    }
}