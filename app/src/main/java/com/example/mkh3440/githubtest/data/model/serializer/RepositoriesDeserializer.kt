package com.example.mkh3440.githubtest.data.model.serializer

import com.example.mkh3440.githubtest.data.model.repository.Repositories
import com.example.mkh3440.githubtest.data.model.repository.Repository
import com.google.gson.JsonDeserializationContext
import com.google.gson.JsonDeserializer
import com.google.gson.JsonElement
import java.lang.reflect.Type

/**
 * Created by kahem on 03/02/2018.
 */
class RepositoriesDeserializer : JsonDeserializer<Repositories> {
    override fun deserialize(json: JsonElement?, typeOfT: Type?, context: JsonDeserializationContext?): Repositories {
        val repositories = Repositories()
        val repositoriesList = ArrayList<Repository>()

        val jsonArray = json?.asJsonArray

        jsonArray?.forEach {
            val repository: Repository? = context?.deserialize(it, Repository::class.java)
            repository?.let { repositoriesList.add(it) }
        }

        repositories.repositories = repositoriesList

        return repositories
    }
}