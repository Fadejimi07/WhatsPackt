package com.example.chat.data

import com.example.chat.model.Message
import com.example.chat.model.MessageContent

fun getFakeMessages(): List<Message> {
    return listOf(
        Message(
            id = "1",
            senderName = "Alice",
            senderAvatar = "https://i.pravater.cc/300?img=1",
            isMine = false,
            timeStamp = "10:00",
            messageContent = MessageContent.TextMessage(
                message = "Hi, how are you"
            )
        ),
        Message(
            id = "2",
            senderName = "Lucy",
            senderAvatar = "https://i.pravater.cc/300?img=2",
            isMine = true,
            timeStamp = "10:01",
            messageContent = MessageContent.TextMessage(
                message = "I am good thank you"
            )
        )
    )
}