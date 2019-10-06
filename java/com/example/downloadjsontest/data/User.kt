package com.example.downloadjsontest.data

import com.google.gson.annotations.SerializedName

class User() {
    var id: Int = 0
    var email: String = ""
    @SerializedName("first_name")
    var name: String = ""
    @SerializedName("last_name")
    var lastName: String = ""
    var avatar: String = ""
}