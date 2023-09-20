package com.sample.api_example_with_compose.views

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModelProvider
import com.sample.api_example_with_compose.model.Post
import com.sample.api_example_with_compose.ui.theme.API_Example_With_ComposeTheme
import com.sample.api_example_with_compose.viewmodel.PostViewModel
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val viewModel = ViewModelProvider(this).get(PostViewModel::class.java)
        setContent {
            val posts by viewModel.posts.observeAsState() // Observe the LiveData
            LaunchedEffect(key1 = true) {
                viewModel.fetchPosts()
            }
            API_Example_With_ComposeTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    posts?.let { PostList(it) }
                }
            }

        }
    }
}

@Composable
fun PostList(posts: List<Post>) {
    LazyColumn {
        items(posts) {
                post ->
            Text(text = post.title, modifier = Modifier.padding(16.dp))
        }
    }

}

