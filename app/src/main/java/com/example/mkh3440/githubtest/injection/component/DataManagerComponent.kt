package com.example.mkh3440.githubtest.injection.component

import com.example.mkh3440.githubtest.data.DataManager
import com.example.mkh3440.githubtest.injection.module.DataManagerModule
import com.example.mkh3440.githubtest.injection.module.ServiceModule
import com.example.mkh3440.githubtest.injection.scope.PerDataManager
import dagger.Subcomponent

/**
 * Created by kahem on 01/02/2018.
 */

@Subcomponent (modules = [DataManagerModule::class, ServiceModule::class])
@PerDataManager
interface DataManagerComponent {
    fun inject(dataManager: DataManager)
}