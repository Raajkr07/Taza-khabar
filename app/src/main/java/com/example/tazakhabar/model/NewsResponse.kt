package com.example.tazakhabar.model

data class NewsResponse(
    val status: String,
    val totalResults: Int,
    val articles: List<Article>
)
