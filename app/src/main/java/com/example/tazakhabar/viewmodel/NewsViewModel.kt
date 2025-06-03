package com.example.tazakhabar.viewmodel

import androidx.lifecycle.*
import com.example.tazakhabar.model.NewsResponse
import com.example.tazakhabar.repository.NewsRepository
import kotlinx.coroutines.launch
import retrofit2.Response

class NewsViewModel(private val repository: NewsRepository) : ViewModel() {

    private val _newsResponse = MutableLiveData<Response<NewsResponse>>()
    val newsResponse: LiveData<Response<NewsResponse>> = _newsResponse

    private val _searchResponse = MutableLiveData<Response<NewsResponse>>()
    val searchResponse: LiveData<Response<NewsResponse>> = _searchResponse

    private val _categoryResponse = MutableLiveData<Response<NewsResponse>>()
    val categoryResponse: LiveData<Response<NewsResponse>> = _categoryResponse

    fun getTopHeadlines(apiKey: String) = viewModelScope.launch {
        val response = repository.getTopHeadlines(apiKey)
        _newsResponse.postValue(response)
    }

    fun searchNews(query: String, apiKey: String) = viewModelScope.launch {
        val response = repository.searchNews(query, apiKey)
        _searchResponse.postValue(response)
    }

    fun getNewsByCategory(category: String, apiKey: String) = viewModelScope.launch {
        val response = repository.getNewsByCategory(category, apiKey)
        _categoryResponse.postValue(response)
    }
}
