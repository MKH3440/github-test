package com.example.mkh3440.githubtest.ui.user

import android.app.Application
import android.content.Context
import com.example.mkh3440.githubtest.R
import com.example.mkh3440.githubtest.data.DataManager
import com.example.mkh3440.githubtest.data.model.repository.Repositories
import com.example.mkh3440.githubtest.injection.component.ApplicationComponent
import com.example.mkh3440.githubtest.ui.base.BasePresenter
import javax.inject.Inject

/**
 * Created by kahem on 03/02/2018.
 */
class UserPresenter(application: Application) : BasePresenter<UserView>(application), UserCallBack {
    @Inject
    lateinit protected var dataManager: DataManager

    @Inject
    lateinit protected var context: Context

    override fun inject(applicationComponent: ApplicationComponent) {
        applicationComponent.inject(this)
    }

    fun getUserRepositories(username: String?) {
        username?.let {
            if (!it.isEmpty()) {
                dataManager.getUserRepositories(username, this)
            }
        }
    }

    override fun onRepositoriesSuccess(repositories: Repositories) {
        view?.showRepositories(repositories.repositories)
    }

    override fun onRepositoriesError(error: Throwable) {
        view?.showError(error.message ?: context.getString(R.string.common_network_error))
    }
}