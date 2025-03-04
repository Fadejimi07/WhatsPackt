package com.example.conversations.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.conversations.R
import com.example.framework.model.Conversation
import com.example.framework.ui.Avatar

@Composable
fun ConversationItem(conversation: Conversation) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Avatar(
            imageUrl = conversation.avatar,
            size = 50.dp,
            contentDescription = stringResource(
                R.string.avatar_content_description,
                conversation.name
            )
        )

        Spacer(modifier = Modifier.width(8.dp))

        Column {
            Text(text = conversation.name)
            if (conversation.unreadCount > 0) {
                Text(
                    text = conversation.unreadCount.toString(),
                    color = MaterialTheme.colorScheme.primary,
                    modifier = Modifier.padding(top = 4.dp)
                )
            }
        }
    }
}