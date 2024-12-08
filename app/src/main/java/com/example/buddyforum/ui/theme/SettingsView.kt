package com.example.buddyforum.ui.theme

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.clickable
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource

import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.buddyforum.R

@Composable
fun SettingView() {
    val settings = listOf(
        "Notification Setting",
        "Theme Setting",
        "Media",
        "Preferences",
        "Privacy"
    )

    Column(
        modifier = Modifier.fillMaxSize().background(
            color = colorResource(R.color.app_bar_color)
        )
    ) {
        settings.forEach { setting ->
            Card(
                shape = RoundedCornerShape(8.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp, horizontal = 16.dp),
                elevation = 4.dp // Adds elevation to each card
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable { /* Add onClick logic here if needed */ }
                        .padding(16.dp), // Padding inside the card
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = setting,
                        fontSize = 18.sp,
                        modifier = Modifier.weight(1f)
                    )
                    Icon(
                        imageVector = Icons.Default.ArrowForward,
                        contentDescription = "Arrow",
                        modifier = Modifier.size(24.dp)
                    )
                }
            }
        }
    }
}


