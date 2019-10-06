package com.example.downloadjsontest.controllers

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.downloadjsontest.R
import com.example.downloadjsontest.data.User
import com.example.downloadjsontest.utils.ImageLoader

class RVUserAdapter(val users: ArrayList<User>) : RecyclerView.Adapter<RVUserAdapter.UserViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.user_card, parent, false)
        return UserViewHolder(view)
    }

    override fun getItemCount(): Int {
        return users.size
    }

    override fun onBindViewHolder(holder: UserViewHolder, i: Int) {
        holder.name.text = users.get(i).name
        holder.lastName.text = users.get(i).lastName
        holder.email.text = users.get(i).email
        ImageLoader().loadImage(
            holder.itemView.context,
            users.get(i).avatar,
            holder.photo)
    }

    inner class UserViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val userCard = itemView.findViewById<CardView>(R.id.userCard)
        val name = itemView.findViewById<TextView>(R.id.nameTextView)
        val lastName = itemView.findViewById<TextView>(R.id.last_nameTextView)
        val email = itemView.findViewById<TextView>(R.id.emailTextView)
        val photo = itemView.findViewById<ImageView>(R.id.photoImage)
    }
}