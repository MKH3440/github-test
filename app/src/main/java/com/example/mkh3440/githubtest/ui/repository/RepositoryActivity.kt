package com.example.mkh3440.githubtest.ui.repository

import android.os.Bundle
import android.text.method.LinkMovementMethod
import com.example.mkh3440.githubtest.R
import com.example.mkh3440.githubtest.data.model.repository.Repository
import com.example.mkh3440.githubtest.ui.base.BaseActivity
import com.example.mkh3440.githubtest.utils.BundleUtils
import kotlinx.android.synthetic.main.content_repository.*
import javax.inject.Inject

/**
 * Created by kahem on 04/02/2018.
 */
class RepositoryActivity : BaseActivity(), RepositoryView {
    override val contentView: Int
        get() = R.layout.activity_repository
    override val menuItemRes: Int?
        get() = null

    @Inject
    lateinit protected var presenter: RepositoryPresenter

    override fun inject() {
        viewComponent.inject(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        presenter.attachView(this)

        val repository: Repository? = intent.extras.getParcelable(BundleUtils.REPOSITORY)
        repository?.let { presenter.formatRepository(it) }
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.detachView()
    }

    override fun showName(name: String) {
        activityRepositoryName.text = name
    }

    override fun showLanguage(language: String) {
        activityRepositoryLanguage.text = language
    }

    override fun showStars(stars: String) {
        activityRepositoryStars.text = stars
    }

    override fun showDescription(description: String) {
        activityRepositoryDescription.text = description
    }

    override fun showCreationDate(creationDate: String) {
        activityRepositoryCreationDate.text = creationDate
    }

    override fun showUpdateDate(updateDate: String) {
        activityRepositoryUpdateDate.text = updateDate
    }

    override fun showUrl(url: String) {
        activityRepositoryUrl.text = url
    }
}