package com.example.chat.domain.usecases

import com.example.chat.domain.IChatRoomRepository
import com.example.chat.domain.models.ChatRoom
import javax.inject.Inject

class GetInitialChatRoomInformation @Inject constructor(private val repository: IChatRoomRepository) {
    suspend operator fun invoke(id: String): ChatRoom {
        return repository.getInitialChatRoom(id)
    }
}