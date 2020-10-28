package com.news.newsbackend.model.notification


data class NotificationToDevice(
        val targetToken: String?,
        val title: String?,
        val body: String?
)