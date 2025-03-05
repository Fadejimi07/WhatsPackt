package com.example.chat.data.network.model

import kotlinx.serialization.Serializable

@Serializable
data class ChatRoomModel(
    val id: String,
    val senderName: String,
    val senderAvatar: String,
    val lastMessages: List<WebsocketMessageModel>
)