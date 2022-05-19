package com.example.coursework.service

import android.content.Context
import android.net.ConnectivityManager

object CheckState {
    fun isConnected(context: Context): Boolean {
        val connectivityManager =context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        return connectivityManager.getActiveNetworkInfo() != null && connectivityManager.activeNetworkInfo!!.isConnected;
    }
}