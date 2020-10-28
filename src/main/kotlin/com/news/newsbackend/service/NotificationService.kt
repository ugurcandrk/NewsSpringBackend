package com.news.newsbackend.service

import com.google.auth.oauth2.GoogleCredentials
import com.google.firebase.FirebaseApp
import com.google.firebase.FirebaseOptions
import com.google.firebase.messaging.FirebaseMessaging
import com.google.firebase.messaging.FirebaseMessagingException
import com.google.firebase.messaging.Message
import com.google.firebase.messaging.Notification
import com.news.newsbackend.model.notification.NotificationToDevice
import com.news.newsbackend.model.notification.NotificationToTopic
import com.news.newsbackend.model.notification.Token
import com.news.newsbackend.model.notification.TopicForSubscription
import com.news.newsbackend.repository.NotificationRepository
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import java.io.FileInputStream
import java.io.IOException
import javax.annotation.PostConstruct

@Service
class NotificationService(private val notificationRepository: NotificationRepository) {

    var logger: Logger = LoggerFactory.getLogger(SavedNewsService::class.java)
    private lateinit var firebaseApp: FirebaseApp

    private val pathOfFirebaseJson = "C:\\Users\\ud\\Desktop\\News Backend\\src\\main\\resources\\newsapplication-b0af6-firebase-adminsdk-t3fc3-cd83d4b68e.json"

    @PostConstruct
    private fun initialize() {

        val serviceAccount = FileInputStream(pathOfFirebaseJson)

        try {
            val options = FirebaseOptions.Builder()
                    .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                    .setDatabaseUrl("https://newsapplication-b0af6.firebaseio.com")
                    .build()

            firebaseApp = if (FirebaseApp.getApps().isEmpty()) {
                FirebaseApp.initializeApp(options)
            } else {
                FirebaseApp.getInstance()
            }
        } catch (e: IOException) {
            logger.error("Create FirebaseApp Error", e)
        }
    }

    fun sendToDevice(notificationToDevice: NotificationToDevice) {

        val message: Message = Message.builder()
                .setToken(notificationToDevice.targetToken)
                .setNotification(Notification.builder()
                        .setTitle(notificationToDevice.title)
                        .setBody(notificationToDevice.body).build())
                .putData("content", notificationToDevice.title)
                .putData("body", notificationToDevice.body)
                .build()

        try {
            FirebaseMessaging.getInstance().send(message)
        } catch (e: FirebaseMessagingException) {
            logger.error("Fail to send notification to Device", e)
        }
    }

    fun saveToken(token: Token) {
        if (!notificationRepository.existsByToken(token.token)) {
            notificationRepository.save(token)
        }
    }

    fun subscribeToTopic(topicForSubscription: TopicForSubscription) {

        val tokenList = notificationRepository.findAll().map { it.token }

        try {
            FirebaseMessaging.getInstance(firebaseApp).subscribeToTopic(tokenList,
                    topicForSubscription.topicName)
        } catch (e: FirebaseMessagingException) {
            logger.error("Fail subscribe to topic fail", e)
        }
    }

    fun unsubscribeFromTopic(topicForSubscription: TopicForSubscription) {

        val tokenList = notificationRepository.findAll().map { it.token }

        try {
            FirebaseMessaging.getInstance(firebaseApp).unsubscribeFromTopic(tokenList,
                    topicForSubscription.topicName)
        } catch (e: FirebaseMessagingException) {
            logger.error("Fail unsubscribe from topic", e)
        }
    }

    fun sendToTopic(notificationToTopic: NotificationToTopic) {

        val message = Message.builder()
                .setTopic(notificationToTopic.topic)
                .setNotification(Notification.builder()
                        .setTitle(notificationToTopic.title)
                        .setBody(notificationToTopic.body).build())
                .putData("content", notificationToTopic.title)
                .putData("body", notificationToTopic.body)
                .build()

        try {
            FirebaseMessaging.getInstance().send(message)
        } catch (e: FirebaseMessagingException) {
            logger.error("Fail to send notification to topic ", e)
        }
    }
}