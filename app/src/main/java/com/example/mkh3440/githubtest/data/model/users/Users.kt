package com.example.mkh3440.githubtest.data.model.users

import com.example.mkh3440.githubtest.data.model.Response
import com.google.gson.annotations.SerializedName

/**
 * Created by kahem on 31/01/2018.
 */
data class Users(
       @SerializedName("items")
       val users: ArrayList<User>) : Response