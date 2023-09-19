package com.example.newsappcompose.ui.screens.home

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.news.api.ApiManager
import com.example.news.api.model.newsResponse.News
import com.example.news.api.model.newsResponse.NewsResponse
import com.example.news.api.model.sourceResponse.Source
import com.example.news.api.model.sourceResponse.SourcesResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class NewsViewModel : ViewModel() {
    val sourcesList: MutableState<List<Source?>?> = mutableStateOf(emptyList())
    val sourceNews: MutableState<Source> = mutableStateOf(Source())
    val newsList: MutableState<List<News?>?> = mutableStateOf(emptyList())
    val isLoading : MutableState<Boolean> = mutableStateOf(false)
    var selectedIndex = mutableIntStateOf(0)
    val pageSize = mutableIntStateOf(20)
    var page = mutableIntStateOf(1)


    fun getSourcesByCategory(category: String?, sourcesList: MutableState<List<Source?>?>) {
        isLoading.value = true
        ApiManager
            .getApis()
            .getSourcesByCategory(category = category ?: "")
            .enqueue(object : Callback<SourcesResponse> {
                override fun onResponse(
                    call: Call<SourcesResponse>,
                    response: Response<SourcesResponse>
                ) {
                    val body = response.body()

                    sourcesList.value = body?.sources ?: emptyList()
                }

                override fun onFailure(call: Call<SourcesResponse>, t: Throwable) {

                }

            }
            )
        isLoading.value = false
    }

    fun getNewsBySources(source: Source?, newsList: MutableState<List<News?>?>,searchText : MutableState<String> = mutableStateOf("")) {
        sourceNews.value = source ?: Source()
        isLoading.value = true
        ApiManager.getApis().getNewsBySource(searchText =searchText.value ,
            sources = source?.id ?: "", pageSize = pageSize.intValue,
            page = page.intValue,
        ).enqueue(
            object : Callback<NewsResponse> {
                override fun onResponse(
                    call: Call<NewsResponse>,
                    response: Response<NewsResponse>
                ) {
                    newsList.value = response.body()?.articles ?: emptyList()
                }
                override fun onFailure(call: Call<NewsResponse>, t: Throwable) {
                }
            }
        )
        isLoading.value = false
    }

}

