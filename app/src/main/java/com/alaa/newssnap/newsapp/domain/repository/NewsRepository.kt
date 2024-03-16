package com.alaa.newssnap.newsapp.domain.repository

import androidx.paging.PagingData
import com.alaa.newssnap.newsapp.domain.model.Article
import kotlinx.coroutines.flow.Flow

interface NewsRepository {

    fun getNews(sources: List<String>): Flow<PagingData<Article>>
    fun getTopHeadlines(sources: List<String>): Flow<PagingData<Article>>


}