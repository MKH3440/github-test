package com.example.mkh3440.githubtest.ui.user

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.mkh3440.githubtest.R
import com.example.mkh3440.githubtest.data.model.repository.Repository

/**
 * Created by kahem on 03/02/2018.
 */
class RepositoriesAdapter(private val context: Context,
                          var repositories: ArrayList<Repository>,
                          private val onRowClicked: (Repository) -> Unit)
    : RecyclerView.Adapter<RepositoriesAdapter.RepositoryViewHolder>() {

    class RepositoryViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        val name: TextView = view.findViewById(R.id.repositoryRowName)
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): RepositoryViewHolder {
        return RepositoryViewHolder(LayoutInflater.from(parent?.context)
                .inflate(R.layout.view_repository_row, parent, false))
    }

    override fun getItemCount(): Int = repositories.size

    override fun onBindViewHolder(holder: RepositoryViewHolder?, position: Int) {
        val repository = repositories[position]

        holder?.name?.text = repository.name
        holder?.view?.setOnClickListener { onRowClicked.invoke(repository) }
    }
}