package com.sample.api_example_with_compose.model

data class Post(val userId: Int,
                val id: Int,
                val title: String,
                val body: String)
//https://jsonplaceholder.typicode.com/posts