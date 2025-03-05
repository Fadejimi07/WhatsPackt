package com.example.chat.domain.usecases

import com.example.chat.domain.IMessagesRepository
import com.example.chat.domain.models.Message
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class RetrieveMessages @Inject constructor(private val repository: IMessagesRepository) {
    suspend operator fun invoke(): Flow<Message> {
        return repository.getMessages()
    }
}