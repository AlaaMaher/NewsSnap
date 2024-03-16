package com.alaa.newssnap.newsapp.presentation.home

import androidx.paging.PagingData
import com.alaa.newssnap.newsapp.domain.model.Article
import kotlinx.coroutines.flow.Flow

data class HomeState(
    var source: List<String> = listOf("bbc-news"),
    val articles: Flow<PagingData<Article>>? = null
)