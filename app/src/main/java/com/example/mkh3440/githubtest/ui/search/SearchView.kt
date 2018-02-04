package com.example.mkh3440.githubtest.ui.search

import com.example.mkh3440.githubtest.data.model.users.User
import com.example.mkh3440.githubtest.ui.base.ApplicationView

/**
 * Created by kahem on 02/02/2018.
 */
interface SearchView: ApplicationView {
    fun showUsers(users: ArrayList<User>)
    fun showError(error: String)
}