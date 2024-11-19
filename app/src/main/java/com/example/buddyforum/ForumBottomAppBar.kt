package com.example.buddyforum
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource



@Composable
fun ForumBottomAppBar(
    onHomeClick: () -> Unit = {},
    onMyComplaintClick: () -> Unit = {},
    onNotesClick: () -> Unit = {}
) {
    BottomAppBar(
        containerColor = Color.White
    ){
        NavigationBar(
            containerColor = Color.White
        ) {
            NavigationBarItem(
                selected = false,
                onClick = onHomeClick,
                icon = {
                    Icon(
                        imageVector = Icons.Default.Home, // Replace with your icon resource
                        contentDescription = "Home",
                        tint = colorResource(id = R.color.app_bar_color)
                    )
                },
                label = { Text("Home", color = colorResource(id = R.color.app_bar_color)) }
            )
            NavigationBarItem(
                selected = false,
                onClick = onMyComplaintClick,
                icon = {
                    Icon(
                        imageVector = Icons.Default.Menu, // Replace with your icon resource
                        contentDescription = "My Complaint",
                        tint = colorResource(id = R.color.app_bar_color)
                    )
                },
                label = { Text("My Complaints", color = colorResource(id = R.color.app_bar_color)) }
            )
            NavigationBarItem(
                selected = false,
                onClick = onNotesClick,
                icon = {
                    Icon(
                        imageVector = Icons.Default.DateRange,
                        contentDescription = "Notes",
                        tint = colorResource(id = R.color.app_bar_color)
                    )
                },
                label = { Text("Notes", color = colorResource(id = R.color.app_bar_color)) }
            )
        }

    }
}