package com.news.newsbackend.repository

import com.news.newsbackend.model.notification.Token
import org.springframework.data.repository.CrudRepository

interface NotificationRepository : CrudRepository<Token, Long> {
    fun existsByToken(token: String): Boolean
}