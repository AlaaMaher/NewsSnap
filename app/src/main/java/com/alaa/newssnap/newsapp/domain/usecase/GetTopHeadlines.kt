package com.alaa.newssnap.newsapp.domain.usecase.newsUseCases

import androidx.paging.PagingData
import com.alaa.newssnap.newsapp.domain.model.Article
import com.alaa.newssnap.newsapp.domain.repository.NewsRepository
import kotlinx.coroutines.flow.Flow

class GetTopHeadlines(private val newsRepository: NewsRepository) {
    operator fun invoke(sources: List<String>): Flow<PagingData<Article>> {
        return newsRepository.getTopHeadlines(sources = sources)
    }
}