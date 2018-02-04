package com.example.mkh3440.githubtest.data.remote

import com.example.mkh3440.githubtest.data.model.repository.Repositories
import com.example.mkh3440.githubtest.data.model.users.Users
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

/**
 * Created by kahem on 30/01/2018.
 */
interface UserService {
    @GET("search/users?per_page=100")
    fun getSearchedUsers(@Query("q", encoded=true) username : String) : Observable<Users>

    @GET("users/{user}/repos?per_page=100")
    fun getUserRepositories(@Path("user") username : String) : Observable<Repositories>
}