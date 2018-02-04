package com.example.mkh3440.githubtest.injection.component

import com.example.mkh3440.githubtest.injection.module.PresenterModule
import com.example.mkh3440.githubtest.injection.scope.PerMvp
import com.example.mkh3440.githubtest.ui.repository.RepositoryActivity
import com.example.mkh3440.githubtest.ui.user.UserActivity
import com.example.mkh3440.githubtest.ui.search.SearchActivity
import com.example.mkh3440.githubtest.ui.search.SearchResultsActivity
import dagger.Subcomponent

/**
 * Created by kahem on 02/02/2018.
 */
@Subcomponent(modules = [PresenterModule::class])
@PerMvp
interface ViewComponent {
    fun inject(searchActivity: SearchActivity)
    fun inject(searchResultsActivity: SearchResultsActivity)
    fun inject(userActivity: UserActivity)
    fun inject(repositoryActivity: RepositoryActivity)
}