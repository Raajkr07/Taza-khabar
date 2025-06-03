package com.example.tazakhabar.repository

import com.example.tazakhabar.api.RetrofitInstance

class NewsRepository {
    suspend fun searchNews(query: String, apiKey: String) =
        RetrofitInstance.api.searchNews(query, apiKey)

    suspend fun getTopHeadlines(apiKey: String) =
        RetrofitInstance.api.getTopHeadlines(apiKey = apiKey)

    suspend fun getNewsByCategory(category: String, apiKey: String) =
        RetrofitInstance.api.getNewsByCategory(category = category, apiKey = apiKey)

}
