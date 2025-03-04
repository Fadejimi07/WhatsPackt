package com.example.conversations.ui

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import com.example.framework.model.Conversation

@Composable
fun ConversationList(
    conversations: List<Conversation>,
    onConversationClick: (chatId: String) -> Unit
) {
    LazyColumn {
        items(conversations) { conversation ->
            ConversationItem(
                conversation = conversation
            )
        }
    }
}
