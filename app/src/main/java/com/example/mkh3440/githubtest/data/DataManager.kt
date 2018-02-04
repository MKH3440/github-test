package com.example.mkh3440.githubtest.data

import android.app.Application
import com.example.mkh3440.githubtest.GithubApp
import com.example.mkh3440.githubtest.data.model.Response
import com.example.mkh3440.githubtest.data.model.repository.Repositories
import com.example.mkh3440.githubtest.data.model.users.Users
import com.example.mkh3440.githubtest.data.remote.UserService
import com.example.mkh3440.githubtest.injection.module.DataManagerModule
import com.example.mkh3440.githubtest.injection.module.ServiceModule
import com.example.mkh3440.githubtest.ui.search.SearchCallBack
import com.example.mkh3440.githubtest.ui.user.UserCallBack
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

/**
 * Created by kahem on 02/02/2018.
 */

class DataManager(application: Application) {
    val usernameQualifier = "+in:login"
    val subscribeScheduler = Schedulers.io()
    val mainThread = AndroidSchedulers.mainThread()

    @Inject
    protected lateinit var userService: UserService

    init {
        (application as GithubApp).applicationComponent.plusDataManagerComponent(DataManagerModule(), ServiceModule())
                .also { it.inject(this) }
    }

    fun <T: Response> callService(call: Observable<T>, callBack: ServiceCallBack<T>) {
        call.subscribeOn(subscribeScheduler)
                .observeOn(mainThread)
                .subscribe(
                        { result: T -> callBack.onSuccess(result) },
                        { error -> callBack.onError(error) }
                )
    }


    abstract class ServiceCallBack<in T: Response> {
        abstract fun onSuccess(response: T)
        abstract fun onError(error: Throwable)
    }

    fun searchUsers(username: String, searchCallBack: SearchCallBack) {
        callService(userService.getSearchedUsers(username + usernameQualifier), object: ServiceCallBack<Users>() {
            override fun onSuccess(response: Users) {
                searchCallBack.onUsersSuccess(response)
            }

            override fun onError(error: Throwable) {
                searchCallBack.onUsersError(error)
            }
        })
    }

    fun getUserRepositories(username: String, userCallBack: UserCallBack) {
        callService(userService.getUserRepositories(username), object: ServiceCallBack<Repositories>() {
            override fun onSuccess(response: Repositories) {
                userCallBack.onRepositoriesSuccess(response)
            }

            override fun onError(error: Throwable) {
                userCallBack.onRepositoriesError(error)
            }
        })
    }
}