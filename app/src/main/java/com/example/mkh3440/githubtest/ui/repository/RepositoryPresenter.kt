package com.example.mkh3440.githubtest.ui.repository

import android.app.Application
import android.content.Context
import com.example.mkh3440.githubtest.R
import com.example.mkh3440.githubtest.data.model.repository.Repository
import com.example.mkh3440.githubtest.injection.component.ApplicationComponent
import com.example.mkh3440.githubtest.ui.base.BasePresenter
import com.example.mkh3440.githubtest.utils.DateUtils
import java.lang.StringBuilder
import javax.inject.Inject

/**
 * Created by kahem on 04/02/2018.
 */
class RepositoryPresenter(application: Application) : BasePresenter<RepositoryView>(application) {
    @Inject
    lateinit protected var context: Context

    override fun inject(applicationComponent: ApplicationComponent) {
        applicationComponent.inject(this)
    }

    fun formatRepository(repository: Repository) {
        view?.showName(repository.name)

        val language = StringBuilder(context.getString(R.string.repository_activity_language))
                .append(": ")
                .append(repository.language)
                .toString()
        view?.showLanguage(language)

        val stars = StringBuilder(context.getString(R.string.repository_activity_stars))
                .append(": ")
                .append(repository.stars)
                .toString()
        view?.showStars(stars)

        view?.showDescription(repository.description)

        val creationDate = StringBuilder(context.getString(R.string.repository_activity_creation_date))
                .append(": ")
                .append(DateUtils.toCommonDate(repository.creationDate))
                .toString()
        view?.showCreationDate(creationDate)

        val updateDate = StringBuilder(context.getString(R.string.repository_activity_update_date))
                .append(": ")
                .append(DateUtils.toCommonDate(repository.updateDate))
                .toString()
        view?.showUpdateDate(updateDate)

        view?.showUrl(repository.url)
    }
}