package com.example.mkh3440.githubtest.injection.module

import android.app.Application
import com.example.mkh3440.githubtest.injection.scope.PerMvp
import com.example.mkh3440.githubtest.ui.repository.RepositoryPresenter
import com.example.mkh3440.githubtest.ui.search.SearchPresenter
import com.example.mkh3440.githubtest.ui.user.UserPresenter
import dagger.Module
import dagger.Provides

/**
 * Created by kahem on 02/02/2018.
 */

@Module
class PresenterModule {
    @Provides
    @PerMvp
    fun providesSearchPresenter(application: Application) : SearchPresenter {
        return SearchPresenter(application)
    }

    @Provides
    @PerMvp
    fun providesUserPresenter(application: Application) : UserPresenter {
        return UserPresenter(application)
    }

    @Provides
    @PerMvp
    fun providesRepositoryPresenter(application: Application) : RepositoryPresenter {
        return RepositoryPresenter(application)
    }
}