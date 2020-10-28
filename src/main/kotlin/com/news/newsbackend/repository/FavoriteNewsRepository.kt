package com.news.newsbackend.repository

import com.news.newsbackend.model.favorite_news.FavoriteNews
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface FavoriteNewsRepository : CrudRepository<FavoriteNews, Long> {
}