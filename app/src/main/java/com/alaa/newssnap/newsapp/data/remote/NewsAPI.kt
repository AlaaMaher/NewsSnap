package com.alaa.newssnap.newsapp.data.remote


import com.alaa.newssnap.BuildConfig.API_KEY
import retrofit2.http.GET
import retrofit2.http.Query





interface NewsAPI {


    @GET("everything")
    suspend fun getNews(
        @Query("page") page:Int,
        @Query("sources") sources: String,
        @Query("apiKey") apiKey: String = API_KEY
    ):NewsResponse

    @GET("top-headlines")
    suspend fun getTopHeadlines(
        @Query("page") page:Int,
        @Query("sources") sources: String,
        @Query("apiKey") apiKey: String = API_KEY
    ):NewsResponse
}