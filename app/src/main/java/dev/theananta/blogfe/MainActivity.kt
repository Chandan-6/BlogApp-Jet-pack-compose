package dev.theananta.blogfe

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SearchBar
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import dev.theananta.blogfe.ui.theme.BlogFETheme
import androidx.compose.material3.Icon
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.dp
import dev.theananta.blogfe.data.BlogData
import dev.theananta.blogfe.ui.BlogPreview.BlogPreview

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BlogFETheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Column(
                        verticalArrangement = Arrangement.spacedBy(16.dp),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier
                            .padding(innerPadding)

                    ) {
                        SearchComp(
                            modifier = Modifier.padding(innerPadding)
                        )

                        val blogDataList = listOf(
                            BlogData(
                                "Google",
                                "20 minutes ago",
                                "Top 10 Ways to Optimize Your Website for SEO",
                                "Learn proven strategies to boost your website's visibility in search engine results."
                            ),
                            BlogData(
                                "Facebook",
                                "1 hour ago",
                                "The Future of Social Media Marketing: Trends and Predictions",
                                "Explore the evolving landscape of social media marketing and discover what's on the horizon."
                            ),
                            BlogData(
                                "Twitter",
                                "3 hours ago",
                                "5 Essential Skills Every Data Scientist Needs in 2023",
                                "Gain insights into the hottest skills in demand for data scientists, from machine learning to data visualization."
                            )
                        )
                        blogDataList.forEach { blogData ->
                            BlogPreview(
                                blogData = blogData, // Pass the BlogData object
                                modifier = Modifier.fillMaxWidth()
                            )
                        }
                    }

                }
            }
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchComp(modifier: Modifier = Modifier) {
    var searchQuery by remember { mutableStateOf("") }
    SearchBar(
        query = searchQuery,
        onQueryChange = { newQuery ->
            searchQuery = newQuery
            print(newQuery)
        },
        active = false,
        onActiveChange = { newQuery ->
            print(newQuery)
        },
        content = {
            Text(text = "")
        },
        onSearch = {},
        placeholder = { Text("Search....") },
        leadingIcon = { Icon(imageVector = Icons.Default.Search, contentDescription = "Search") },
        trailingIcon = {
            if (searchQuery.isNotEmpty()) {
                IconButton(onClick = {}) {
                    Icon(imageVector = Icons.Default.Close, contentDescription = "Clear")
                }
            }
        },
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    BlogFETheme {
        SearchComp()
    }
}