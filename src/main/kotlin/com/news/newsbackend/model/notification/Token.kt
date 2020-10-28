package com.news.newsbackend.model.notification

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
data class Token(
        @Id @GeneratedValue(strategy = GenerationType.AUTO)
        val id: Long?,
        val token: String
)