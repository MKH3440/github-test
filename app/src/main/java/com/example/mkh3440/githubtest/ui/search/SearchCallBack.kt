package com.example.mkh3440.githubtest.ui.search

import com.example.mkh3440.githubtest.data.model.users.Users

/**
 * Created by kahem on 02/02/2018.
 */
interface SearchCallBack {
    fun onUsersSuccess(users: Users)
    fun onUsersError(error: Throwable)
}