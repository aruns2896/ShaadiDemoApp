package com.example.shaadidemoapp

import android.app.Application
import com.example.shaadidemoapp.network.ApiModule
import com.example.shaadidemoapp.network.MainRepository
import com.practice.demo.db.DatabaseModule
import com.practice.demo.db.MatchProfileRepository

class ApplicationClass: Application(){

    lateinit var mainRepository: MainRepository
    lateinit var repo: MatchProfileRepository

    override fun onCreate() {
        super.onCreate()
        initialize()
    }

    private fun initialize() {
        val apiService = ApiModule.provideApiService(
            ApiModule.provideRetrofit(
                ApiModule.provideOkHttpClient(ApiModule.provideLoggingInterceptor())
            )
        )
        val appDatabase = DatabaseModule.provideDatabase(applicationContext)
        val profileDao = DatabaseModule.provideProfileDao(appDatabase)
        repo = MatchProfileRepository(
            profileDao = profileDao
        )
        mainRepository = MainRepository(apiService, repo)

    }
}