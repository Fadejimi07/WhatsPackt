package com.example.chat.model

data class Message(
    val id: String,
    val senderName: String,
    val senderAvatar: String,
    val timeStamp: String,
    val isMine: Boolean,
    val messageContent: MessageContent
)