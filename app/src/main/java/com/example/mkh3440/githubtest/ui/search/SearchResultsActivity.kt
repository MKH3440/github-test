package com.example.mkh3440.githubtest.ui.search

import android.content.Intent
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.example.mkh3440.githubtest.utils.BundleUtils
import com.example.mkh3440.githubtest.R
import com.example.mkh3440.githubtest.data.model.users.User
import com.example.mkh3440.githubtest.ui.base.BaseActivity
import com.example.mkh3440.githubtest.ui.user.UserActivity
import kotlinx.android.synthetic.main.content_search_results.*

/**
 * Created by kahem on 03/02/2018.
 */
class SearchResultsActivity : BaseActivity() {
    override val contentView: Int
        get() = R.layout.activity_search_results
    override val menuItemRes: Int?
        get() = null

    override fun inject() {
        viewComponent.inject(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val users: ArrayList<User>? = intent.extras.getParcelableArrayList(BundleUtils.USERS_LIST)
        users?.let { showUsers(it) }
    }

    private fun showUsers(users: ArrayList<User>) {
        activitySearchResultsRecyclerView?.layoutManager = LinearLayoutManager(this)
        activitySearchResultsRecyclerView?.adapter = UsersAdapter(this, users, {
            val intent = Intent(this, UserActivity::class.java)
                    .apply { this.putExtra(BundleUtils.USER, it) }
            startActivity(intent)
            finish()
        })
    }
}