package com.example.mkh3440.githubtest.data.model.users

import android.annotation.SuppressLint
import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

/**
 * Created by kahem on 30/01/2018.
 */

@SuppressLint("ParcelCreator")
@Parcelize
data class User(
        @SerializedName("login") val username: String,
        @SerializedName("avatar_url") val avatarUrl: String
) : Parcelable