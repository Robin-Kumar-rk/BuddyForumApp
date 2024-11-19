package com.example.buddyforum

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn

import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.foundation.lazy.items
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.sp

// Data class for TeamMember
data class TeamMember(
    val name: String,
    val role: String,
    val description: String
)


@Composable
fun TeamInfo() {
    // List of team members
    val teamMembers = listOf(
        TeamMember("Neha", "Backend Developer", "Responsible for server-side logic & database."),
        TeamMember("Namrata", "UI Designer", "Managing the project User Interface."),
        TeamMember("Nakshatra", "Git/Github Handler", "Manage Repo's on github"),
        TeamMember("Robin", "Android Developer", "Building robust and efficient Android apps."),
        TeamMember("Ritik", "Frontend Developer", "Manage Frontend of website i.e. React"),
        TeamMember("Prabhakar", "Frontend Developer ", "Manage Frontend of website i.e. Tailwind CSS.")
    )

    // Display the team information in a scrollable column
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp).background(color = colorResource(id = R.color.app_bar_color)),
        verticalArrangement = Arrangement.spacedBy(16.dp) // Adds spacing between items
    ) {
        item {
            Text("Our Team", style = TextStyle(fontSize = 24.sp, fontWeight = FontWeight.Bold))
            Spacer(modifier = Modifier.height(16.dp))
        }
        items(teamMembers) { member ->
            TeamMemberCard(member)
        }
    }
}

@Composable
fun TeamMemberCard(member: TeamMember) {
    Card(
        colors = CardDefaults.cardColors(containerColor = Color(0xFFD1C1F3)),
        modifier = Modifier.fillMaxWidth(),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = member.name, color = Color.Black,
                style = TextStyle(fontSize = 20.sp, fontWeight = FontWeight.Bold)
            )
            Column {
                Text(
                    text = "Role: ${member.role}",
                    style = TextStyle(fontSize = 16.sp, color = Color.Black)
                )
                Text(
                    text = member.description,
                    style = TextStyle(fontSize = 14.sp, color = Color.Black),
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis
                )
            }
        }
    }
}



@Preview
@Composable
fun PreviewMainScreen() {
    TeamInfo()
}
