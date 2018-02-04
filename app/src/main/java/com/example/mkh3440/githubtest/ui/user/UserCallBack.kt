package com.example.mkh3440.githubtest.ui.user

import com.example.mkh3440.githubtest.data.model.repository.Repositories

/**
 * Created by kahem on 03/02/2018.
 */
interface UserCallBack {
    fun onRepositoriesSuccess(repositories: Repositories)
    fun onRepositoriesError(error: Throwable)
}