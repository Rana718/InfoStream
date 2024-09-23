package com.example.infostream

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.kwabenaberko.newsapilib.models.Article

@Composable
fun HomePage(newsViewModel: NewsViewModel){


    val articles by newsViewModel.articles.observeAsState(emptyList())

    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        LazyColumn(
            modifier = Modifier.fillMaxSize()
        ) {
            items(articles) { article ->
                ArticleItem(article)
            }
        }
    }
}

@Composable
fun ArticleItem(article: Article) {
    Card (
        modifier = Modifier.padding(8.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxSize().padding(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ){
            AsyncImage(
                model = article.urlToImage,
                contentDescription = "Article Image",
                modifier = Modifier.size(80.dp).aspectRatio(1f),
                contentScale = ContentScale.Crop
            )
            Column(
                modifier = Modifier.fillMaxSize().padding(start = 8.dp)
            ) {
                Text(
                    text = article.title,
                    fontWeight = FontWeight.Bold,
                    maxLines = 3
                )
                Text(
                    text = article.source.name,
                    maxLines = 1,
                    fontSize = 14.sp
                )
            }
        }
    }
}
