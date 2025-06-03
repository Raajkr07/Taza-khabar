# 📰 Taza Khabar

**Taza Khabar** is a modern Android news application that delivers real-time news headlines using a public news API. Built with **Kotlin**, **Jetpack Compose**, and **XML**, the app provides users with a smooth and intuitive experience to stay updated with the latest news from around the world.

---

## 🌟 Features

- 🔥 **Real-time News**: Fetches latest news headlines from reliable news sources
- 🧭 **Clean UI**: Modern interface built with Jetpack Compose and XML
- 🌐 **Connectivity Handling**: Smart internet connectivity check and error handling
- 📱 **Device Compatibility**: Supports a wide range of Android devices
- 💡 **Performance**: Lightweight architecture with fast loading times
- 🔍 **News Categories**: Browse news by different categories
- 📖 **Detailed View**: Full article details with images and content
- 🔄 **Pull to Refresh**: Easy refresh mechanism for latest updates

---

## 🛠️ Tech Stack

| Category | Technology |
|----------|------------|
| **Language** | Kotlin |
| **UI Framework** | Jetpack Compose, XML |
| **Architecture** | MVVM (Model-View-ViewModel) |
| **IDE** | Android Studio |
| **Networking** | Retrofit2 + OkHttp3 |
| **JSON Parsing** | Gson |
| **Image Loading** | Glide/Coil |
| **Dependency Injection** | Hilt (optional) |
| **API** | [NewsAPI.org](https://newsapi.org/) |

---

## 📦 Project Structure

```
com.example.tazakhabar/
│
├── api/
│   ├── NewsApiService.kt          # Retrofit API interface
│   └── RetrofitInstance.kt        # Singleton Retrofit client
│
├── model/
│   ├── Article.kt                 # Data class for news article
│   ├── NewsResponse.kt            # API response model
│   └── Source.kt                  # News source data class
│
├── repository/
│   └── NewsRepository.kt          # Data repository layer
│
├── ui/
│   ├── adapter/
│   │   ├── ArticleDiffCallback.kt # RecyclerView diff utility
│   │   └── NewsAdapter.kt         # News list adapter
│   │
│   ├── fragments/
│   │   ├── HeadlinesFragment.kt   # Main headlines screen
│   │   ├── CategoriesFragment.kt  # News categories
│   │   └── NewsDetailFragment.kt  # Article detail view
│   │
│   ├── compose/
│   │   ├── NewsCard.kt            # Compose news item
│   │   ├── LoadingState.kt        # Loading indicators
│   │   └── ErrorState.kt          # Error handling UI
│   │
│   ├── theme/
│   │   ├── Color.kt               # App color scheme
│   │   ├── Theme.kt               # Material theme setup
│   │   └── Type.kt                # Typography definitions
│   │
│   └── MainActivity.kt            # Main activity entry point
│
├── viewmodel/
│   ├── NewsViewModel.kt           # Main ViewModel
│   └── NewsViewModelFactory.kt    # ViewModel factory
│
└── utils/
    ├── Constants.kt               # App constants
    ├── NetworkUtils.kt            # Network utility functions
    └── DateUtils.kt               # Date formatting utilities
```
---

## 🔌 API Integration

The app uses the [NewsAPI.org](https://newsapi.org/) service to fetch news data:

- **Endpoints Used:**
  - `/v2/top-headlines` - Latest headlines
  - `/v2/everything` - Search articles
  - `/v2/sources` - News sources

- **Sample API Response:**
```json
{
  "status": "ok",
  "totalResults": 70,
  "articles": [
    {
      "source": {
        "id": "bbc-news",
        "name": "BBC News"
      },
      "author": "BBC News",
      "title": "Sample News Title",
      "description": "Sample news description...",
      "url": "https://www.bbc.com/news/sample",
      "urlToImage": "https://sample-image-url.jpg",
      "publishedAt": "2024-01-15T10:30:00Z",
      "content": "Full article content..."
    }
  ]
}
```

---

## 🏗️ Architecture

The app follows the **MVVM (Model-View-ViewModel)** architecture pattern:

- **Model**: Data classes and API response models
- **View**: UI components (Activities, Fragments, Compose screens)
- **ViewModel**: Business logic and state management
- **Repository**: Data source abstraction layer

### Data Flow

```
API → Repository → ViewModel → UI
```

---

## 🧪 Testing

### Running Tests

```bash
# Unit tests
./gradlew test

# Instrumented tests  
./gradlew connectedAndroidTest
```

### Test Structure

```
src/
├── test/                    # Unit tests
│   ├── repository/
│   ├── viewmodel/
│   └── utils/
│
└── androidTest/             # Instrumented tests
    ├── ui/
    └── database/
```

---

## 🤝 Contributing

We welcome contributions! Please follow these steps:

1. **Fork the repository**
2. **Create a feature branch**
   ```bash
   git checkout -b feature/amazing-feature
   ```
3. **Commit your changes**
   ```bash
   git commit -m 'Add some amazing feature'
   ```
4. **Push to the branch**
   ```bash
   git push origin feature/amazing-feature
   ```
5. **Open a Pull Request**

### Contribution Guidelines

- Follow Kotlin coding conventions
- Write unit tests for new features
- Update documentation as needed
- Ensure all tests pass before submitting PR

---

## 📜 License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

```
MIT License

Copyright (c) 2024 Raj Kumar

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
```

---

## 🙏 Acknowledgments

- [NewsAPI.org](https://newsapi.org/) for providing the news data API
- [Android Developers](https://developer.android.com/) for comprehensive documentation
- [Jetpack Compose](https://developer.android.com/jetpack/compose) team for the modern UI toolkit
- All contributors who helped improve this project

---

**Made with ❤️ for the Android community**
