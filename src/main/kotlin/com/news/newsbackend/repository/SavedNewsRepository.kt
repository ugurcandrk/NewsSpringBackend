package com.news.newsbackend.repository

import com.news.newsbackend.model.saved_news.SavedNews
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface SavedNewsRepository : CrudRepository<SavedNews, Long> {
    fun findByTitle(title: String): Iterable<SavedNews>
    fun existsByTitle(title: String): Boolean
    fun deleteByTitle(title: String)
}