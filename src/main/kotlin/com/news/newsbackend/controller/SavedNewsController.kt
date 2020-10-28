package com.news.newsbackend.controller

import com.news.newsbackend.model.saved_news.CreateSavedNewsRequest
import com.news.newsbackend.model.saved_news.toSavedNews
import com.news.newsbackend.service.SavedNewsService
import org.springframework.web.bind.annotation.*


@RequestMapping("/saved-news")
@RestController
class SavedNewsController(private val savedNewsService: SavedNewsService) {

    @RequestMapping("/news")
    private fun getAllSavedNews() =
            savedNewsService.getAllSavedNews()


    @PostMapping("/save")
    private fun saveSavedNews(@RequestBody createSavedNewsRequest: CreateSavedNewsRequest) {
        savedNewsService.saveSavedNews(createSavedNewsRequest.toSavedNews())
    }

    @DeleteMapping("/delete/{title}")
    private fun deleteSavedNews(@PathVariable title: String) {
        savedNewsService.deleteSavedNews(title)
    }
}