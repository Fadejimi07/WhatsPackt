package com.example.framework.model

data class Conversation(
    val id: String,
    val name: String,
    val message: String,
    val timestamp: String,
    val unreadCount: Int,
    val avatar: String,
)