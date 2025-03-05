package com.example.chat.data.repository

import com.example.chat.data.network.datasource.ChatRoomDataSource
import com.example.chat.domain.IChatRoomRepository
import javax.inject.Inject

class ChatRoomRepository @Inject constructor(
    private val dataSource: ChatRoomDataSource
) : IChatRoomRepository {
    override suspend fun getInitialChatRoom(id: String): ChatRoom {
        val chatRoomApiModel = dataSource.getInitialChatRoom(id)
        return chatRoomApiModel.toDoamin()
    }
}