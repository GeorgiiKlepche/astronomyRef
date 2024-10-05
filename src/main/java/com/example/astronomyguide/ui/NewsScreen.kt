package com.example.astronomyguide.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.astronomyguide.viewmodel.NewsViewModel

@Composable
fun NewsScreen(viewModel: NewsViewModel = viewModel()) {
    val news = viewModel.newsState

    Column(Modifier.fillMaxSize()) {
        news.forEach { newsItem ->
            Row(Modifier.weight(1f).padding(8.dp)) {
                Text(text = newsItem.text, fontSize = 16.sp)
            }
        }
    }
}
