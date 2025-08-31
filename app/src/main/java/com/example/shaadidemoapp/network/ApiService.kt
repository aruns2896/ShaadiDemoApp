package com.example.shaadidemoapp.network

import com.example.shaadidemoapp.models.response.UserResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("api/") // Base URL will be "https://randomuser.me/"
    suspend fun getUsers(
        @Query("results") count: Int

    ): Response<UserResponse> // Using Response wrapper

}