package com.example.mkh3440.githubtest.ui.repository

import com.example.mkh3440.githubtest.ui.base.ApplicationView

/**
 * Created by kahem on 04/02/2018.
 */
interface RepositoryView : ApplicationView {
    fun showName(name: String)
    fun showLanguage(language: String)
    fun showStars(stars: String)
    fun showDescription(description: String)
    fun showCreationDate(creationDate: String)
    fun showUpdateDate(updateDate: String)
    fun showUrl(url: String)
}