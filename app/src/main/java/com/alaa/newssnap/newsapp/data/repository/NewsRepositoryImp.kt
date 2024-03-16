package com.alaa.newssnap.newsapp.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.alaa.newssnap.newsapp.data.remote.NewsAPI
import com.alaa.newssnap.newsapp.data.remote.NewsPagingSources
import com.alaa.newssnap.newsapp.data.remote.TopHeadlinesPagingSources
import com.alaa.newssnap.newsapp.domain.model.Article
import com.alaa.newssnap.newsapp.domain.repository.NewsRepository
import kotlinx.coroutines.flow.Flow

class NewsRepositoryImp(private val newsAPI: NewsAPI) : NewsRepository {
    override fun getNews(sources: List<String>): Flow<PagingData<Article>> {
        return Pager(
            config = PagingConfig(pageSize = 10),
            pagingSourceFactory = {
                NewsPagingSources(
                    newsApi = newsAPI,
                    sources = sources.joinToString(separator = ",")
                )
            }
        ).flow
    }

    override fun getTopHeadlines(sources: List<String>): Flow<PagingData<Article>> {
        return Pager(
            config = PagingConfig(pageSize = 10),
            pagingSourceFactory = {
                TopHeadlinesPagingSources(
                    newsApi = newsAPI,
                    sources = sources.joinToString(separator = ",")
                )
            }
        ).flow
    }
}