package com.example.mkh3440.githubtest.data.model.repository

import android.annotation.SuppressLint
import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

/**
 * Created by kahem on 03/02/2018.
 */

@SuppressLint("ParcelCreator")
@Parcelize
data class Repository(
        @SerializedName("name") val name: String,
        @SerializedName("language") val language: String,
        @SerializedName("stargazers_count") val stars: Int,
        @SerializedName("description") val description: String,
        @SerializedName("created_at") val creationDate: String,
        @SerializedName("updated_at") val updateDate: String,
        @SerializedName("html_url") val url: String
) : Parcelable