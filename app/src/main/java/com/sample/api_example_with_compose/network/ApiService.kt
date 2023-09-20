package com.sample.api_example_with_compose.network

import com.sample.api_example_with_compose.model.Post
import retrofit2.Response
import retrofit2.http.GET

//https://jsonplaceholder.typicode.com/posts

interface ApiService {
    @GET("posts")
    suspend fun getPosts(): Response<List<Post>>
}