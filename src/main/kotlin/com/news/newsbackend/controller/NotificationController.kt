package com.news.newsbackend.controller

import com.news.newsbackend.model.notification.NotificationToDevice
import com.news.newsbackend.model.notification.NotificationToTopic
import com.news.newsbackend.model.notification.Token
import com.news.newsbackend.model.notification.TopicForSubscription
import com.news.newsbackend.service.NotificationService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RequestMapping("/notification")
@RestController
class NotificationController(private val notificationService: NotificationService) {

    @PostMapping("/send-device")
    private fun sendToDevice(@RequestBody notificationToDevice: NotificationToDevice) {
        return notificationService.sendToDevice(notificationToDevice)
    }

    @PostMapping("/save-token")
    private fun saveToken(@RequestBody token: Token) {
        notificationService.saveToken(token)
    }


    @PostMapping("/subscribe")
    private fun subscribeToTopic(@RequestBody topicForSubscription: TopicForSubscription) {
        notificationService.subscribeToTopic(topicForSubscription)
    }

    @PostMapping("/unsubscribe")
    private fun unsubscribeFromTopic(topicForSubscription: TopicForSubscription) {
        notificationService.unsubscribeFromTopic(topicForSubscription)
    }

    @PostMapping("/send-topic")
    private fun sendToTopic(@RequestBody notificationToTopic: NotificationToTopic) {
        notificationService.sendToTopic(notificationToTopic)
    }
}