package com.example.chat.domain

interface IChatRoomRepository {
    suspend fun getInitialChatRoom(id: String): ChatRoom
}