package com.example.tazakhabar.api

import com.example.tazakhabar.model.NewsResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApiService {
    @GET("top-headlines")
    suspend fun getTopHeadlines(
        @Query("country") country: String = "us",
        @Query("apiKey") apiKey: String
    ): Response<NewsResponse>

    @GET("everything")
    suspend fun searchNews(
        @Query("q") query: String,
        @Query("apiKey") apiKey: String
    ): Response<NewsResponse>

    @GET("top-headlines")
    suspend fun getNewsByCategory(
        @Query("country") country: String = "in",
        @Query("category") category: String,
        @Query("apiKey") apiKey: String
    ): Response<NewsResponse>
}
