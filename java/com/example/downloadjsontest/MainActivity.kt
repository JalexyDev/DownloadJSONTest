package com.example.downloadjsontest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.downloadjsontest.controllers.RVUserAdapter
import com.example.downloadjsontest.utils.AsyncFillUI

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        fillUI()
    }

    fun fillUI() {
        AsyncFillUI(this).execute()
    }


}
