package com.example.buddyforum

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.ui.Modifier
import com.example.buddyforum.ui.theme.BuddyForumTheme
import androidx.appcompat.app.AppCompatDelegate
import com.example.buddyforum.ui.theme.MainView


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
            BuddyForumTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize().windowInsetsPadding(WindowInsets.ime)
                ) { innerPadding ->
                    MainView( Modifier.padding(innerPadding))
                }
            }
        }
    }
}






