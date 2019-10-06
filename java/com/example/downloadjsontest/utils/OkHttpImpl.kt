package com.example.downloadjsontest.utils

import okhttp3.*
import okhttp3.OkHttpClient



class OkHttpImpl(var url: String) {

    var client = OkHttpClient()

    fun getJsonString() : String? {

        val builder = Request.Builder()
        builder.url(url)
        val request = builder.build()

        try {
            val response = client.newCall(request).execute()
            return response.body()?.string()
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return null
    }
}