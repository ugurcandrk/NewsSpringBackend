package com.news.newsbackend

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class NewsBackendApplication

fun main(args: Array<String>) {
    runApplication<NewsBackendApplication>(*args)
}
