package com.example.mkh3440.githubtest.ui.search

import android.app.Application
import android.content.Context
import com.example.mkh3440.githubtest.R
import com.example.mkh3440.githubtest.data.DataManager
import com.example.mkh3440.githubtest.data.model.users.Users
import com.example.mkh3440.githubtest.injection.component.ApplicationComponent
import com.example.mkh3440.githubtest.ui.base.BasePresenter
import javax.inject.Inject

/**
 * Created by kahem on 02/02/2018.
 */
class SearchPresenter(application: Application): BasePresenter<SearchView>(application), SearchCallBack {
    @Inject
    lateinit protected var dataManager: DataManager

    @Inject
    lateinit protected var context: Context

    override fun inject(applicationComponent: ApplicationComponent) {
        applicationComponent.inject(this)
    }

    fun searchUsers(username: String?) {
        username?.let {
            if (!it.isEmpty()) {
                dataManager.searchUsers(username, this)
            }
        }
    }

    override fun onUsersError(error: Throwable) {
        view?.showError(error.message ?: context.getString(R.string.common_network_error))
    }

    override fun onUsersSuccess(users: Users) {
        view?.showUsers(users.users)
    }

}