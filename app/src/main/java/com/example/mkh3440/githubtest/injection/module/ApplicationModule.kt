package com.example.mkh3440.githubtest.injection.module

import android.app.Application
import android.content.Context
import com.example.mkh3440.githubtest.data.DataManager
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by kahem on 01/02/2018.
 */

@Module
class ApplicationModule(val application: Application) {

    @Provides
    @Singleton
    fun providesApplication() : Application {
        return application
    }

    @Provides
    @Singleton
    fun providesContext() : Context {
        return application.applicationContext
    }

    @Provides
    @Singleton
    fun providesDataManager() : DataManager {
        return DataManager(application)
    }
}