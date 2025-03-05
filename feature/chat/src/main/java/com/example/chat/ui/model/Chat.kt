package com.example.chat.ui.model

import com.example.chat.domain.models.ChatRoom

data class Chat(
    val id: String,
    val name: String,
    val avatar: String
)

fun ChatRoom.toUI() = run {
    Chat(
        id = id,
        name = senderName,
        avatar = senderAvatar,
    )
}