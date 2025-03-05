package com.example.chat.data.repository

import com.example.chat.data.network.datasource.MessagesSocketDataSource
import com.example.chat.domain.IMessagesRepository
import com.example.chat.domain.models.Message
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class MessagesRepository @Inject constructor(
    private val dataSource: MessagesSocketDataSource
) : IMessagesRepository {
    override suspend fun getMessages(): Flow<Message> {
        return dataSource.connect()
    }

    override suspend fun sendMessage(message: Message) {
        dataSource.sendMessage(message)
    }

    override suspend fun disconnect() {
        dataSource.disconnect()
    }
}