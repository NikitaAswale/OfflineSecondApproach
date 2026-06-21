package com.example.offlinesecondapproach

import retrofit2.http.GET

interface ApiService {

    @GET("posts")
    suspend fun getUsers(): List<UserDto>
}