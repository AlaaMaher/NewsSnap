package com.alaa.newssnap.newsapp.di



import com.alaa.newssnap.newsapp.data.remote.NewsAPI
import com.alaa.newssnap.newsapp.data.repository.NewsRepositoryImp
import com.alaa.newssnap.newsapp.domain.repository.NewsRepository
import com.alaa.newssnap.newsapp.domain.usecase.newsUseCases.GetNewsUseCase
import com.alaa.newssnap.newsapp.domain.usecase.newsUseCases.GetTopHeadlines
import com.alaa.newssnap.newsapp.domain.usecase.newsUseCases.NewsUseCases
import com.alaa.newssnap.util.Constants.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideNewsAPI(): NewsAPI {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(NewsAPI::class.java)
    }

    @Provides
    @Singleton
    fun provideNewRepository(
        newsAPI: NewsAPI
    ): NewsRepository = NewsRepositoryImp(newsAPI)

    @Provides
    @Singleton
    fun provideNewsCases(newsRepository: NewsRepository): NewsUseCases {
        return NewsUseCases(
            getNewsUseCase = GetNewsUseCase(newsRepository),
            topHeadlines = GetTopHeadlines(newsRepository)
        )
    }

}