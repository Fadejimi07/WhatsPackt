package com.example.chat.ui.model

sealed class MessageContent {
    data class TextMessage(val message: String) : MessageContent()
    data class ImageMessage(val imageUrl: String, val contentDescription: String) : MessageContent()
}