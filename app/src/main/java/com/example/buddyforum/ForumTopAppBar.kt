package com.example.buddyforum

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.SmallTopAppBar
import androidx.compose.material3.Text

import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ForumTopAppBar(
    onNotificationClick: () -> Unit,
    onNavigateToLoginScreen: () -> Unit,
    onAboutClick: () -> Unit,
    onContactClick: () -> Unit,
    onRoadmapClick: () -> Unit
) {
    var expanded by remember { mutableStateOf(false) }
    val navigationIcon: @Composable (() -> Unit) =

        {
            Image(
                painter = painterResource(id = R.drawable.logo),
                contentDescription = "App Logo", // Provide a meaningful description for accessibility
                modifier = Modifier.size(40.dp) // Adjust size as needed
            )
        }

    SmallTopAppBar(
        title = {
            Text(
                text = "Buddy Forum",
                color = Color.White,
                modifier = Modifier
                    .padding(start = 4.dp)
                    .heightIn(max = 24.dp)
            )
        },
        navigationIcon = navigationIcon,
        actions = {
            IconButton(onClick = onNotificationClick) {
                Icon(
                    imageVector = Icons.Default.Notifications, // Replace with your preferred notification icon
                    contentDescription = "Notifications",
                    tint = Color.White
                )
            }
            IconButton(onClick = onNavigateToLoginScreen) {
                Icon(
                    imageVector = Icons.Default.AccountCircle, // Replace with your preferred notification icon
                    contentDescription = "User",
                    tint = Color.White
                )
            }
            IconButton(onClick = {
                expanded = true
            }) {
                Icon(
                    imageVector = Icons.Default.MoreVert, // Replace with your preferred menu icon
                    contentDescription = "Menu",
                    tint = Color.White
                )
            }
            DropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false },
                modifier = Modifier.width(200.dp).background(Color.White),
            ) {
                DropdownMenuItem(
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Default.LocationOn,
                            contentDescription = "Roadmap",
                            tint = colorResource(id = R.color.app_bar_color)
                        )
                    },
                    text = { Text("Roadmap", color = colorResource(id = R.color.app_bar_color)) },
                    onClick = {
                        // Handle option 1 click
                        expanded = false
                        onRoadmapClick()
                    },
                )
                DropdownMenuItem(
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Default.Settings,
                            contentDescription = "Settings",
                            tint = colorResource(id = R.color.app_bar_color)
                        )
                    },
                    onClick = {
                        // Handle option 2 click
                        expanded = false

                    },
                    text = { Text("Settings", color = colorResource(id = R.color.app_bar_color)) }
                )
                DropdownMenuItem(
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Default.AccountBox,
                            contentDescription = "contact",
                            tint = colorResource(id = R.color.app_bar_color)
                        )
                    },
                    onClick = {
                        // Handle option 3 click
                        expanded = false
                        onContactClick()
                    },
                    text = { Text("Contact", color = colorResource(id = R.color.app_bar_color)) }
                )
                DropdownMenuItem(
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Default.Info,
                            contentDescription = "about",
                            tint = colorResource(id = R.color.app_bar_color)
                        )
                    },
                    onClick = {
                        // Handle option 3 click
                        expanded = false
                        onAboutClick()
                    },
                    text = { Text("About", color = colorResource(id = R.color.app_bar_color)) }
                )
            }
        },
        colors = TopAppBarDefaults.smallTopAppBarColors(
            containerColor = colorResource(id = R.color.app_bar_color)
        )
    )
}



