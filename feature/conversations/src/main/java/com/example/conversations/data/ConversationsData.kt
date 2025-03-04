package com.example.conversations.data

import com.example.framework.model.Conversation

fun generateFakeConversations(): List<Conversation> =
    listOf(
        Conversation(
            id = "1",
            name = "John Doe",
            message = "Hey hou are you",
            timestamp = "10:10",
            avatar = "https://i.pravater.cc/150?u=1",
            unreadCount = 2,
        ),
        Conversation(
            id = "2",
            name = "John Doe",
            message = "Hey hou are you",
            timestamp = "11:13",
            avatar = "https://i.pravater.cc/150?u=2",
            unreadCount = 2,
        )
    )