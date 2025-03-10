package com.example.data

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Build.VERSION_CODES.O
import androidx.core.app.NotificationCompat
import com.example.framework.navigation.DeepLinks
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage

class WhatsPacktMessagingService : FirebaseMessagingService() {
    companion object {
        const val CHANNEL_ID = "Chat_message"
        const val CHANNEL_DESCRIPTION = "Receive a notification when a chat message is received"
        const val CHANNEL_TITLE = "New chat message notification"
    }

    override fun onMessageReceived(remoteMessage: RemoteMessage) {
        super.onMessageReceived(remoteMessage)
        if (remoteMessage.data.isNotEmpty()) {
            val senderName = remoteMessage.data["senderName"]
            val messageContent = remoteMessage.data["message"]
            val chatId = remoteMessage.data["chatId"]
            val messageId = remoteMessage.data["messageId"]
            if (chatId != null && messageId != null) {
                // create and show a notification for the message
                showNotification(senderName, messageId, messageContent, chatId)
            }
        }
    }

    private fun showNotification(
        senderName: String?, messageId: String, messageContent: String?,
        chatId: String
    ) {
        val notificationManager =
            getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        val channel = NotificationChannel(
            CHANNEL_ID, CHANNEL_TITLE, NotificationManager.IMPORTANCE_DEFAULT
        ).apply {
            description = CHANNEL_DESCRIPTION
        }

        notificationManager.createNotificationChannel(channel)
        val deepLinkUrl = DeepLinks.chatRoute.replace("{chatId}", chatId)
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(deepLinkUrl)).apply {
            flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        }

        // Create a PendingIntent for the Intent
        val pendingIntent = PendingIntent.getActivity(this, O, intent, PendingIntent.FLAG_IMMUTABLE)

        // Build the notification
        val notification = NotificationCompat.Builder(
            this, CHANNEL_ID
        ).setSmallIcon(R.drawable.baseline_notifications_24)
            .setContentTitle(senderName)
            .setContentText(messageContent)
            .setContentIntent(pendingIntent)
            .setAutoCancel(true)
            .build()

        // show notification
        notificationManager.notify(messageId.toInt()    11 )
    }
}