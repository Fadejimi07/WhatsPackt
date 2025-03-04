package com.example.conversations.ui

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.rounded.Menu
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.conversations.R
import com.example.conversations.data.ConversationsListTab
import com.example.conversations.data.generateFakeConversations
import com.example.conversations.util.generateTabs

@Composable
fun ConversationsListScreen(
    onNewConversationClick: () -> Unit,
    onConversationClick: (chatId: String) -> Unit
) {
    val tabs = generateTabs()
    val conversations = generateFakeConversations()
    var selectedIndex by rememberSaveable {
        mutableStateOf(1)
    }
    var pagerState = rememberPagerState(initialPage = 1, pageCount = { tabs.size })
    Scaffold(
        topBar = {
            ConversationTopBar()
        },
        bottomBar = {
            ConversationBottomBar(tabs = tabs, selectedIndex = selectedIndex)
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = {}
            ) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = stringResource(R.string.conversation_add_fab_title)
                )
            }
        },
    ) { innerPadding ->
        HorizontalPager(
            modifier = Modifier.padding(innerPadding),
            state = pagerState
        ) { index ->
            when (index) {
                0 -> {
                    // status
                }

                1 -> {
                    ConversationList(
                        conversations = conversations,
                        onConversationClick = onConversationClick
                    )
                }

                2 -> {
                    // calls
                }
            }
        }
        LaunchedEffect(selectedIndex) {
            pagerState.animateScrollToPage(selectedIndex)
        }
    }
}

@Composable
fun ConversationBottomBar(
    tabs: List<ConversationsListTab>,
    selectedIndex: Int
) {
    TabRow(selectedTabIndex = 1, modifier = Modifier.padding(16.dp)) {
        tabs.forEachIndexed { index, tab ->
            Tab(
                selected = index == selectedIndex,
                onClick = {}
            ) {
                Text(text = stringResource(tab.title))
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ConversationTopBar() {
    TopAppBar(
        title = {
            Text(text = stringResource(id = R.string.conversations_list_title))
        },
        actions = {
            IconButton(
                onClick = { }
            ) {
                Icon(
                    Icons.Rounded.Menu,
                    contentDescription = stringResource(id = R.string.menu)
                )
            }
        }
    )
}