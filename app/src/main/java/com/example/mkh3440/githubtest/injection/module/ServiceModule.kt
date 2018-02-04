package com.example.mkh3440.githubtest.injection.module

import com.example.mkh3440.githubtest.data.model.repository.Repositories
import com.example.mkh3440.githubtest.data.model.serializer.RepositoriesDeserializer
import com.example.mkh3440.githubtest.injection.scope.PerDataManager
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by kahem on 01/02/2018.
 */

@Module
class ServiceModule {
    private val endpoint = "https://api.github.com/"

    @Provides
    @PerDataManager
    fun providesRetrofit() : Retrofit {
        val gsonBuilder = GsonBuilder().apply { registerTypeAdapter(Repositories::class.java, RepositoriesDeserializer()) }

        return Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gsonBuilder.create()))
                .baseUrl(endpoint)
                .build()
    }
}