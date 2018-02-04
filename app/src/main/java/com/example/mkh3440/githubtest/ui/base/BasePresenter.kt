package com.example.mkh3440.githubtest.ui.base

import android.app.Application
import com.example.mkh3440.githubtest.GithubApp
import com.example.mkh3440.githubtest.injection.component.ApplicationComponent

/**
 * Created by kahem on 02/02/2018.
 */
abstract class BasePresenter<ApplicationView>(application: Application) {
    var view: ApplicationView? = null
    var applicationComponent = (application as GithubApp).applicationComponent

    fun attachView(view: ApplicationView) {
        this.view = view
        inject(applicationComponent)
    }

    fun detachView() {
        view = null
    }

    abstract fun inject(applicationComponent: ApplicationComponent)
}