package com.news.newsbackend.model.saved_news

import com.news.newsbackend.model.common.Source

data class CreateSavedNewsRequest(
        val source: Source?,
        val author: String?,
        val title: String?,
        val description: String?,
        val url: String?,
        val urlToImage: String?,
        val publishedAt: String?,
        val content: String?
)

fun CreateSavedNewsRequest.toSavedNews() =
        SavedNews(
                source = this.source,
                author = this.author,
                title = this.title,
                description = this.description,
                url = this.url,
                urlToImage = this.urlToImage,
                publishedAt = this.publishedAt,
                content = this.content
        )