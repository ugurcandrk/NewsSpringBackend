package com.news.newsbackend.model.common

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
data class Source(
        @Id @GeneratedValue(strategy = GenerationType.AUTO)
        val id: Long?,
        val name: String?
)