# 📰 Taza Khabar

**Taza Khabar** is a modern Android news app that fetches and displays real-time news headlines using a public news API. Built with **Kotlin**, **Jetpack Compose**, and **XML**, the app offers users a smooth and intuitive way to stay updated with the latest news.

## 📱 Features

- 🔥 Real-time news fetched from a News API
- 🧭 Simple, clean user interface built with Jetpack Compose
- 🌐 Internet connectivity check and error handling
- 📱 Compatible with a wide range of Android devices
- 💡 Lightweight and fast performance

## 🛠️ Tech Stack

| Category        | Tech Used                          |
|----------------|-------------------------------------|
| Language        | Kotlin                             |
| UI Framework    | Jetpack Compose, XML               |
| IDE             | Android Studio                     |
| Networking      | Retrofit / OkHttp (assumed)        |
| JSON Parsing    | Gson / Moshi (assumed)             |
| API             | [NewsAPI.org](https://newsapi.org/) |

## 📦 Project Structure

com.example.tazakhabar
│
├── api/
│ ├── NewsApiService.kt # Retrofit API interface
│ └── RetrofitInstance.kt # Singleton Retrofit client
│
├── model/
│ ├── Article.kt # Data class for article item
│ └── NewsResponse.kt # Full response model
│
├── repository/
│ └── NewsRepository.kt # Handles API data fetching
│
├── ui/
│ ├── adapter/
│ │ ├── ArticleDiffCallback.kt # Efficient diffing for RecyclerView
│ │ └── NewsAdapter.kt # RecyclerView adapter for news
│ │
│ ├── fragments/
│ │ ├── HeadlinesFragment.kt # Displays headlines
│ │ └── NewsDetailFragment.kt # Displays article details
│ │
│ ├── theme/
│ │ ├── Color.kt
│ │ ├── Theme.kt
│ │ └── Type.kt
│ │
│ └── MainActivity.kt # Entry point with Compose setup
│
└── viewmodel/
├── NewsViewModel.kt # ViewModel for UI logic
└── NewsViewModelFactory.kt # Factory for ViewModel injection

### Prerequisites

- Android Studio (latest stable version recommended)
- Gradle 7+
- A valid News API key (e.g., from [NewsAPI.org](https://newsapi.org))

### Setup Instructions

1. **Clone the repository:**
   ```bash
   git clone https://github.com/Raajkr07/Taza-Khabar.git
