package com.example.downloadjsontest.utils

import com.example.downloadjsontest.data.User
import com.google.gson.GsonBuilder
import org.json.JSONArray
import org.json.JSONObject

class GsonParser(var jsonString: String) {

    fun parseJsonToUserArray(arKey: String) : ArrayList<User> {
        val list = ArrayList<User>()
        if (jsonString != null) {
            val gson = GsonBuilder().create()
            val obj = JSONObject(jsonString)
            val jsonAr: JSONArray = obj.getJSONArray(arKey)

            for (i in 0..jsonAr.length()-1) {
                val user = gson.fromJson<User>(jsonAr[i].toString(), User::class.java)
                list.add(user)
            }
        }
        return list
    }
}