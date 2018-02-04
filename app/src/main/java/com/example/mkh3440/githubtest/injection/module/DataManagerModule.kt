package com.example.mkh3440.githubtest.injection.module

import com.example.mkh3440.githubtest.data.remote.UserService
import com.example.mkh3440.githubtest.injection.scope.PerDataManager
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

/**
 * Created by kahem on 01/02/2018.
 */

@Module
class DataManagerModule {
    @Provides
    @PerDataManager
    fun providesUserService(retrofit: Retrofit) : UserService {
        return retrofit.create(UserService::class.java)
    }
}