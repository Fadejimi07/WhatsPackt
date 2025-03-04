package com.example.whatspackt.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.chat.ui.ChatScreen
import com.example.conversations.ui.ConversationsListScreen
import com.example.create_chat.ui.CreateConversationScreen
import com.example.framework.navigation.NavRoutes

@Composable
fun MainNavigation(navController: NavHostController = rememberNavController()) {
    NavHost(
        navController = navController,
        startDestination = NavRoutes.ConversationList
    ) {
        // Add composables destinations here
        addConversationList(navController)
        addNewConversation(navController)
        addChat(navController)
    }
}

private fun NavGraphBuilder.addConversationList(navController: NavHostController) {
    composable(NavRoutes.ConversationList) {
        ConversationsListScreen(
            onNewConversationClick = {
                navController.navigate(
                    NavRoutes.NewConversation
                )
            },
            onConversationClick = { chatId ->
                navController.navigate(NavRoutes.Chat.replace("{chatId}", chatId))
            }
        )
    }
}

private fun NavGraphBuilder.addNewConversation(navController: NavHostController) {
    composable(NavRoutes.NewConversation) {
        CreateConversationScreen(
            onCreateConversation = {
                navController.navigate(NavRoutes.Chat)
            }
        )
    }
}

private fun NavGraphBuilder.addChat(navController: NavHostController) {
    composable(
        route = NavRoutes.Chat,
        arguments = listOf(navArgument(NavRoutes.ChatArgs.ChatId) {
            type = NavType.StringType
        })
    ) { navBackStackEntry ->
        val chatId = navBackStackEntry.arguments?.getString(NavRoutes.ChatArgs.ChatId)
        ChatScreen(chatId = chatId, onBack = {
            navController.popBackStack()
        })
    }
}