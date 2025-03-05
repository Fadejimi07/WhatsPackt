package com.example.chat.domain

import com.example.chat.domain.models.Message
import kotlinx.coroutines.flow.Flow

interface IMessagesRepository {
    suspend fun getMessages(): Flow<Message>
    suspend fun sendMessage(message: Message)
    suspend fun disconnect()
}