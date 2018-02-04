package com.example.mkh3440.githubtest.injection.component

import com.example.mkh3440.githubtest.injection.module.ApplicationModule
import com.example.mkh3440.githubtest.injection.module.DataManagerModule
import com.example.mkh3440.githubtest.injection.module.PresenterModule
import com.example.mkh3440.githubtest.injection.module.ServiceModule
import com.example.mkh3440.githubtest.ui.repository.RepositoryPresenter
import com.example.mkh3440.githubtest.ui.search.SearchPresenter
import com.example.mkh3440.githubtest.ui.user.UserPresenter
import dagger.Component
import javax.inject.Singleton

/**
 * Created by kahem on 01/02/2018.
 */


@Component(modules = [ApplicationModule::class])
@Singleton
interface ApplicationComponent {
    fun plusDataManagerComponent(dataManagerModule: DataManagerModule, serviceModule: ServiceModule) : DataManagerComponent
    fun plusViewComponent(presenterModule: PresenterModule) : ViewComponent

    fun inject(searchPresenter: SearchPresenter)
    fun inject(userPresenter: UserPresenter)
    fun inject(repositoryPresenter: RepositoryPresenter)
}