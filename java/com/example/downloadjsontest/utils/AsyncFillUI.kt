package com.example.downloadjsontest.utils

import android.app.Activity
import android.content.Context
import android.os.AsyncTask
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.downloadjsontest.R
import com.example.downloadjsontest.controllers.RVMenuAdapter
import com.example.downloadjsontest.controllers.RVUserAdapter
import com.example.downloadjsontest.data.User

class AsyncFillUI(val context: Context) : AsyncTask<Unit, Unit, Unit>() {
    var users = ArrayList<User>()

    //todo сюда подгружать список кнопок
    val menuItems = arrayListOf("Users", "Subscribes", "Another shit", "Pipica", "Pipirka")

    override fun doInBackground(vararg params: Unit?) {
        val okHttpClient = OkHttpImpl("https://reqres.in/api/users/")
        val jsonString = okHttpClient.getJsonString()
        users = GsonParser(jsonString!!).parseJsonToUserArray("data")

    }

    override fun onPostExecute(result: Unit?) {
        super.onPostExecute(result)
        fillUI()
    }

    private fun fillUI() {
        fillMenuItems()
        fillUserCards()
    }

    private fun fillMenuItems() {
        val activity = context as Activity
        val recycler = activity.findViewById<RecyclerView>(R.id.menu)
        recycler.setHasFixedSize(true)
        recycler.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
        recycler.adapter = RVMenuAdapter(menuItems)
    }

    private fun fillUserCards() {
        val activity = context as Activity
        val recycler = activity.findViewById<RecyclerView>(R.id.userCards)
        recycler.setHasFixedSize(true)
        recycler.layoutManager = LinearLayoutManager(activity)
        recycler.adapter = RVUserAdapter(users)
    }

}