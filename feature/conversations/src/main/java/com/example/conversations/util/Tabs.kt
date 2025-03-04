package com.example.conversations.util

import com.example.conversations.R
import com.example.conversations.data.ConversationsListTab

fun generateTabs(): List<ConversationsListTab> {
    return listOf(
        ConversationsListTab(R.string.conversations_tab_status_title),
        ConversationsListTab(R.string.conversations_tab_chats_title),
        ConversationsListTab(R.string.conversations_tab_calls_title)
    )
}