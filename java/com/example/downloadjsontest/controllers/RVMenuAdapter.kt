package com.example.downloadjsontest.controllers

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.RecyclerView
import com.example.downloadjsontest.R

class RVMenuAdapter(val menuItems: ArrayList<String>) : RecyclerView.Adapter<RVMenuAdapter.MenuViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MenuViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.menu_item, parent, false)
        return MenuViewHolder(view)
    }

    override fun getItemCount(): Int {
        return menuItems.size
    }

    override fun onBindViewHolder(holder: MenuViewHolder, i: Int) {
        holder.button.text = menuItems.get(i)
    }


    inner class MenuViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val button = itemView.findViewById<Button>(R.id.menu_btn)

        //todo сделать объект MenuItem состоящий из пары Name Path где:
        // Name - текст кнопки
        // Path - добавляемый путь к ссылке
        // Написать тут обработчик нажатия при котором путь добавляется к ссылке
    }
}