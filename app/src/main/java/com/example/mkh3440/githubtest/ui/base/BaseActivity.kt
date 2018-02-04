package com.example.mkh3440.githubtest.ui.base

import android.content.Intent
import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.view.View
import com.example.mkh3440.githubtest.GithubApp
import com.example.mkh3440.githubtest.R
import com.example.mkh3440.githubtest.injection.component.ViewComponent
import com.example.mkh3440.githubtest.injection.module.PresenterModule
import com.example.mkh3440.githubtest.ui.search.SearchActivity
import kotlinx.android.synthetic.main.activity_search.*
import kotlinx.android.synthetic.main.app_bar.*

abstract class BaseActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener, ApplicationView {
    abstract val contentView: Int
    abstract val menuItemRes: Int?
    var menuItem: MenuItem? = null
    lateinit var viewComponent: ViewComponent
    var loader: View? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(contentView)
        viewComponent = (application as GithubApp).applicationComponent.plusViewComponent(PresenterModule())
        inject()

        loader = findViewById(R.id.loader)

        menuItemRes?.let { menuItem = navView.menu.findItem(it) }
        setSupportActionBar(toolbar)

        val toggle = ActionBarDrawerToggle(
                this, drawer_layout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        drawer_layout.addDrawerListener(toggle)
        toggle.syncState()

        navView.setNavigationItemSelectedListener(this)
        menuItem?.isChecked = true

    }

    override fun onBackPressed() {
        if (drawer_layout.isDrawerOpen(GravityCompat.START)) {
            drawer_layout.closeDrawer(GravityCompat.START)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        return false
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        var intent: Intent? = null

        if (item != menuItem) {
            when (item.itemId) {
                R.id.navSearch -> {
                    intent = Intent(this, SearchActivity::class.java)
                }
            }
        }

        drawer_layout.closeDrawer(GravityCompat.START)
        intent?.let {
            startActivity(intent)
            this.finish()
        }
        return true
    }

    abstract fun inject()

    protected fun showLoader() {
        loader?.visibility = View.VISIBLE
    }

    protected fun hideLoader() {
        loader?.visibility = View.GONE
    }
}
