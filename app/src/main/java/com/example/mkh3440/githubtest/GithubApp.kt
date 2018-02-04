package com.example.mkh3440.githubtest

import android.app.Application
import com.example.mkh3440.githubtest.injection.component.ApplicationComponent
import com.example.mkh3440.githubtest.injection.component.DaggerApplicationComponent
import com.example.mkh3440.githubtest.injection.module.ApplicationModule

/**
 * Created by kahem on 01/02/2018.
 */

class GithubApp : Application() {
    val applicationComponent: ApplicationComponent by lazy {
        DaggerApplicationComponent
                .builder()
                .applicationModule(ApplicationModule(this))
                .build()
    }
}