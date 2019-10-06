package com.example.downloadjsontest.utils

import android.content.Context
import android.widget.ImageView
import com.bumptech.glide.Glide

class ImageLoader {

    fun loadImage(context: Context, url: String, imageView: ImageView) {
        Glide.with(context)
            .load(url)
            .into(imageView)
    }
}