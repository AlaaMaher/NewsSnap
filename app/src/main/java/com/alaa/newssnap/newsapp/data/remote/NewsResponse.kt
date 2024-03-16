package com.alaa.newssnap.newsapp.data.remote

import com.alaa.newssnap.newsapp.domain.model.Article


data class NewsResponse(
    val articles: List<Article>,
    val status: String,
    val totalResults: Int
)