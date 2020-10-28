package com.news.newsbackend.model.saved_news

import com.news.newsbackend.model.common.Source
import javax.persistence.*

@Entity
data class SavedNews(
        @Id @GeneratedValue(strategy = GenerationType.AUTO)
        val id: Long? = -1,
        @OneToOne(cascade = [CascadeType.ALL])
        val source: Source?,
        @Column(columnDefinition = "text")
        val author: String?,
        @Column(columnDefinition = "text")
        val title: String?,
        @Column(columnDefinition = "text")
        val description: String?,
        @Column(columnDefinition = "text")
        val url: String?,
        @Column(columnDefinition = "text")
        val urlToImage: String?,
        val publishedAt: String?,
        @Column(columnDefinition = "text")
        val content: String?
)

fun SavedNews.toSavedNewsResponse() =
        SavedNewsResponse(
                id = this.id,
                source = this.source,
                author = this.author,
                title = this.title,
                description = this.description,
                url = this.url,
                urlToImage = this.urlToImage,
                publishedAt = this.publishedAt,
                content = this.content
        )