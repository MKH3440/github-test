package com.example.mkh3440.githubtest.ui.search

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.example.mkh3440.githubtest.data.model.users.User
import com.example.mkh3440.githubtest.R
import com.squareup.picasso.Picasso

/**
 * Created by kahem on 03/02/2018.
 */
class UsersAdapter(private val context: Context,
                   var users: ArrayList<User>,
                   private val onRowClicked: (User) -> Unit)
    : RecyclerView.Adapter<UsersAdapter.UserViewHolder>() {

    class UserViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        val userImage: ImageView = view.findViewById(R.id.userRowImage)
        val usernameText: TextView = view.findViewById(R.id.userRowUsername)
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): UserViewHolder {
        return UserViewHolder(LayoutInflater.from(parent?.context)
                .inflate(R.layout.view_user_row, parent, false))
    }

    override fun getItemCount(): Int = users.size

    override fun onBindViewHolder(holder: UserViewHolder?, position: Int) {
        val user = users[position]

        holder?.usernameText?.text = user.username
        Picasso.with(context).load(user.avatarUrl).placeholder(R.drawable.ic_search).into(holder?.userImage)
        holder?.view?.setOnClickListener { onRowClicked.invoke(user) }
    }
}