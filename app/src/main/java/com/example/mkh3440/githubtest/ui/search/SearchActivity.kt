package com.example.mkh3440.githubtest.ui.search

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.mkh3440.githubtest.utils.BundleUtils
import com.example.mkh3440.githubtest.R
import com.example.mkh3440.githubtest.data.model.users.User
import com.example.mkh3440.githubtest.ui.base.BaseActivity
import kotlinx.android.synthetic.main.content_search.*
import kotlinx.android.synthetic.main.view_loader.*
import javax.inject.Inject

/**
 * Created by kahem on 30/01/2018.
 */

class SearchActivity : BaseActivity(), SearchView {
    override val contentView = R.layout.activity_search
    override val menuItemRes = R.id.navSearch

    @Inject
    lateinit var presenter: SearchPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter.attachView(this)

        activitySearchSearchButton.setOnClickListener {
            showLoader()
            presenter.searchUsers(activitySearchSearchBar.text.toString())
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.detachView()
    }

    override fun inject() {
        viewComponent.inject(this)
    }

    override fun showError(error: String) {
        hideLoader()
        Toast.makeText(this, error, Toast.LENGTH_LONG).show()
    }

    override fun showUsers(users: ArrayList<User>) {
        val intent = Intent(this, SearchResultsActivity::class.java)
                .apply { this.putParcelableArrayListExtra(BundleUtils.USERS_LIST, users) }
        startActivity(intent)
        finish()
    }
}