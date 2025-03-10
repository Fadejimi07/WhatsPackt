package com.example.data

import com.google.firebase.messaging.FirebaseMessaging
import kotlinx.coroutines.tasks.await
import javax.inject.Inject

class FCMTokenDataSource @Inject constructor(
    private val firebaseMessaging: FirebaseMessaging = FirebaseMessaging.getInstance()
) {
    suspend fun getFcmToken(): String? {
        return try {
            FirebaseMessaging.getInstance().token.await()
        } catch (e: Exception) {
            null
        }
    }
}