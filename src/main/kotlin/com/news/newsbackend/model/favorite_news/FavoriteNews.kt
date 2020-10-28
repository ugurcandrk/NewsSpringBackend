package com.news.newsbackend.model.favorite_news

import com.news.newsbackend.model.common.Source
import javax.persistence.*

@Entity
data class FavoriteNews(
        @Id @GeneratedValue(strategy = GenerationType.AUTO)
        val id: Long,
        @OneToOne
        val source: Source,
        val author: String,
        val title: String,
        val description: String,
        val url: String,
        val urlToImage: String,
        val publishedAt: String,
        val content: String
)