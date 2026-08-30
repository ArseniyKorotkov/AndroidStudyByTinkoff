package by.arsy.androidstudybytinkoff

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.widget.Toast

class NetworkChangeReceiver : BroadcastReceiver() {

    override fun onReceive(
        context: Context,
        intent: Intent
    ) {
        val manager = context.getSystemService(
            Context.CONNECTIVITY_SERVICE
        ) as ConnectivityManager

        val activeNetwork = manager.activeNetwork
        val networkCapabilities = manager.getNetworkCapabilities(activeNetwork)
        val isCapability = networkCapabilities != null && networkCapabilities.hasCapability(
            NetworkCapabilities.NET_CAPABILITY_INTERNET
        )
        Toast.makeText(
            context,
            "Network is available: $isCapability",
            Toast.LENGTH_LONG
        ).show()
    }
}