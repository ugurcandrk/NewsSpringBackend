package com.news.newsbackend.model.saved_news

import com.news.newsbackend.model.common.Source

data class SavedNewsResponse(
        val id: Long?,
        val source: Source?,
        val author: String?,
        val title: String?,
        val description: String?,
        val url: String?,
        val urlToImage: String?,
        val publishedAt: String?,
        val content: String?
)