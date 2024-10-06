package com.example.astronomyguide.viewmodel

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel

data class NewsItem(val text: String, var likes: Int)

class NewsViewModel : ViewModel() {

    private val _newsList = listOf("Новость 1", "Новость 2", "Новость 3", "Новость 4")

    // Состояние новостей как список для Compose
    val newsState = mutableStateListOf<NewsItem>()

    init {
        resetNews()
    }

    private fun resetNews() {
        newsState.clear()
        newsState.addAll(_newsList.map { NewsItem(it, 0) })
    }
    fun incrementLikes(index: Int) {
        newsState[index] = newsState[index].copy(likes = newsState[index].likes + 1)
    }

}
