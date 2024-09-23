package com.example.infostream

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.kwabenaberko.newsapilib.NewsApiClient
import com.kwabenaberko.newsapilib.models.Article
import com.kwabenaberko.newsapilib.models.request.TopHeadlinesRequest
import com.kwabenaberko.newsapilib.models.response.ArticleResponse
import java.util.Objects


class NewsViewModel : ViewModel() {

    private val _articles = MutableLiveData<List<Article>>()
    val articles: LiveData<List<Article>> = _articles

    init {
        fetchTeNewsTopHeadlines()
    }

    fun fetchTeNewsTopHeadlines() {
        val newsApiClient = NewsApiClient(constant.ApiKey)
        val request = TopHeadlinesRequest.Builder().language("en").build()

        newsApiClient.getTopHeadlines(request, object : NewsApiClient.ArticlesResponseCallback {

            override fun onSuccess(response: ArticleResponse?) {
                response?.articles?.let {
                    _articles.value = response.articles
                }
            }

            override fun onFailure(throwable: Throwable?) {
                if(throwable != null){
                    Log.i("NewsAPI Response Failed", throwable.message.toString() )
                }
            }
        })
    }
}
