package com.example.framework.navigation

object NavRoutes {
    const val ConversationList = "conversations_list"
    const val NewConversation = "create_conversation"
    const val Chat = "chat/{chatId}"

    object ChatArgs {
        const val ChatId = "chatId"
    }
}