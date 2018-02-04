package com.example.mkh3440.githubtest.ui.user

import android.content.Intent
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.widget.Toast
import com.example.mkh3440.githubtest.R
import com.example.mkh3440.githubtest.data.model.repository.Repository
import com.example.mkh3440.githubtest.data.model.users.User
import com.example.mkh3440.githubtest.ui.base.BaseActivity
import com.example.mkh3440.githubtest.ui.repository.RepositoryActivity
import com.example.mkh3440.githubtest.utils.BundleUtils
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.content_user.*
import kotlinx.android.synthetic.main.view_user_row.*
import javax.inject.Inject

/**
 * Created by kahem on 03/02/2018.
 */
class UserActivity: BaseActivity(), UserView {
    override val contentView: Int
        get() = R.layout.activity_user
    override val menuItemRes: Int?
        get() = null

    @Inject
    lateinit protected var presenter: UserPresenter

    override fun inject() {
        viewComponent.inject(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter.attachView(this)

        val user: User? = intent.extras.getParcelable(BundleUtils.USER)
        user?.let {
            showUser(it)
            showLoader()
            presenter.getUserRepositories(it.username)
        }

    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.detachView()
    }

    override fun showRepositories(repositories: ArrayList<Repository>) {
        hideLoader()
        activityUserRecyclerView?.layoutManager = LinearLayoutManager(this)
        activityUserRecyclerView?.adapter = RepositoriesAdapter(this, repositories, {
            val intent = Intent(this, RepositoryActivity::class.java)
                    .apply { this.putExtra(BundleUtils.REPOSITORY, it) }
            startActivity(intent)
            finish()
        })
    }

    override fun showError(error: String) {
        hideLoader()
        Toast.makeText(this, error, Toast.LENGTH_LONG).show()
    }

    private fun showUser(user: User) {
        userRowUsername.text = user.username
        Picasso.with(this).load(user.avatarUrl).placeholder(R.drawable.ic_search).into(userRowImage)
    }
}