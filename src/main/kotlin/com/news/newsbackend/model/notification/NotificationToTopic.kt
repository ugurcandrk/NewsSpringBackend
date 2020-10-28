package com.news.newsbackend.model.notification

data class NotificationToTopic(
        val topic: String,
        val title: String,
        val body: String
)