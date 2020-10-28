package com.news.newsbackend.service

import com.news.newsbackend.model.saved_news.SavedNews
import com.news.newsbackend.model.saved_news.toSavedNewsResponse
import com.news.newsbackend.repository.SavedNewsRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional


@Service
@Transactional

class SavedNewsService(private val savedNewsRepository: SavedNewsRepository) {

    fun getAllSavedNews() =
            savedNewsRepository.findAll().map {
                it.toSavedNewsResponse()
            }

    fun saveSavedNews(savedNews: SavedNews) {
        savedNewsRepository.save(savedNews)
    }

    fun deleteSavedNews(title: String) {
        if (savedNewsRepository.existsByTitle(title)) {
            savedNewsRepository.deleteByTitle(title)
        }
    }
}