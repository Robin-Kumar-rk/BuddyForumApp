package com.example.buddyforum.ui.theme

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn

import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import com.example.buddyforum.R
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.res.colorResource


// Notification data class
data class Notification(
    val id: Int,
    val title: String,
    val description: String
)

@Composable
fun NotificationsView() {
    // Dummy data
    var notifications by remember {
        mutableStateOf(
            listOf(
                Notification(1, "Severity Update", "\"Wi-Fi Not Working\" has been updated to major"),
                Notification(2, "App Update", "A new version of the app is available."),
            )
        )
    }

    // Composable function for Notification Item
    @Composable
    fun NotificationItem(notification: Notification, onDelete: (Int) -> Unit) {
        var menuExpanded by remember { mutableStateOf(false) }
        val appColor = colorResource(id = R.color.app_bar_color)
        Card(
            shape = RoundedCornerShape(8.dp),
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            elevation = 4.dp // Add elevation for the Card
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Column(modifier = Modifier.weight(1f)) {
                    Text(text = notification.title, fontSize = 18.sp, style = MaterialTheme.typography.h6, color = appColor)
                    Text(text = notification.description, fontSize = 14.sp, style = MaterialTheme.typography.body2, color = appColor)
                }

                // Three-dot button with DropdownMenu
                Box {
                    IconButton(onClick = { menuExpanded = !menuExpanded }) {
                        Icon(Icons.Default.MoreVert, contentDescription = "Options")
                    }
                    DropdownMenu(
                        expanded = menuExpanded,
                        onDismissRequest = { menuExpanded = false }
                    ) {
                        DropdownMenuItem(onClick = {
                            menuExpanded = false
                            onDelete(notification.id)
                        }) {
                            Text("Delete")
                        }
                    }
                }
            }
        }
    }


    // Notifications list
    LazyColumn(
        modifier = Modifier.fillMaxSize().background(
            color = colorResource(id = R.color.app_bar_color)
        )
    ) {
        items(notifications) { notification ->
            NotificationItem(notification) { id ->
                notifications = notifications.filter { it.id != id }
            }
        }
    }
}

