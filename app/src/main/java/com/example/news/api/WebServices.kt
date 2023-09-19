package com.example.news.api

import com.example.news.api.model.newsResponse.NewsResponse
import com.example.news.api.model.sourceResponse.SourcesResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface WebServices {

    @GET("v2/top-headlines/sources")
    fun getSourcesByCategory(
        @Query("apiKey") key : String = ApiConstants.API_KEY,
        @Query("category") category : String
    ) : Call<SourcesResponse>

    @GET("v2/everything")
    fun getNewsBySource(
        @Query("apiKey") key : String = ApiConstants.API_KEY,
        @Query("sources") sources : String,
        @Query("q") searchText : String = "",
        @Query("pageSize") pageSize :Int,
        @Query("page") page : Int,
    ) : Call<NewsResponse>

    @GET("v2/everything")
    fun getNewsBySearch(
        @Query("apiKey") key : String = ApiConstants.API_KEY,
        @Query("q") searchText : String = "",
    ) : Call<NewsResponse>
}