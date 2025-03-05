package com.example.chat.domain.usecases

import com.example.chat.domain.IMessagesRepository
import javax.inject.Inject

class DisconnectMessage @Inject constructor(private val repository: IMessagesRepository) {
    suspend operator fun invoke() {
        repository.disconnect()
    }
}