package com.example.whatspackt

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.rememberNavController
import com.example.whatspackt.navigation.MainNavigation
import com.example.whatspackt.ui.theme.WhatsPacktTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            WhatsPacktTheme {
                val navController = rememberNavController()
                MainNavigation(navController = navController)
            }
        }
    }
}