package com.example.mkh3440.githubtest.ui.user

import com.example.mkh3440.githubtest.data.model.repository.Repository
import com.example.mkh3440.githubtest.ui.base.ApplicationView

/**
 * Created by kahem on 03/02/2018.
 */
interface UserView : ApplicationView {
    fun showRepositories(repositories: ArrayList<Repository>)
    fun showError(error: String)
}