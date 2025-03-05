package com.example.chat.domain.usecases

import com.example.chat.domain.IMessagesRepository
import com.example.chat.domain.models.Message
import javax.inject.Inject

class SendMessage @Inject constructor(
    private val repository: IMessagesRepository
) {
    suspend operator fun invoke(message: Message) {
        repository.sendMessage(message = message)
    }
}
