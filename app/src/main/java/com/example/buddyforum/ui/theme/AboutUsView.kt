package com.example.buddyforum.ui.theme

import android.content.Intent

import android.net.Uri
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items

import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults

import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.buddyforum.R

// Data class for TeamMember
data class TeamMember(
    val name: String,
    val linkedInUrl: String,
    val githubUrl: String
)

@Composable
fun AboutUsScreen() {
    // List of team members with LinkedIn and GitHub URLs
    val teamMembers = listOf(
        TeamMember("Prabhakar", "https://www.linkedin.com/in/nakshatra-sirohi/", "https://github.com/NakshatraSirohi"),
        TeamMember("Neha", "https://www.linkedin.com/in/neha-ojha0028/", "https://github.com/ItsNehaOjha"),
        TeamMember("Namrata", "https://www.linkedin.com/in/neha-ojha0028/", "https://github.com/ItsNehaOjha"),
        TeamMember("Nakshatra", "https://www.linkedin.com/in/nakshatra-sirohi/", "https://github.com/NakshatraSirohi"),
        TeamMember("Robin", "https://www.linkedin.com/in/robin-kumar-rk/", "https://github.com/Robin-Kumar-rk"),
        TeamMember("Ritik", "https://www.linkedin.com/in/rkritiktyagi/", "https://github.com/rkritiktyagi"),

    )

    // Display the team information in a scrollable column
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(color = colorResource(R.color.app_bar_color)),
         // Adds spacing between items
    ) {
        items(teamMembers) { member ->
            TeamMemberCard(member)
        }
    }
}

@Composable
fun TeamMemberCard(member: TeamMember) {
    Card(
        colors = CardDefaults.cardColors(containerColor = Color(0xFFD1C1F3)),
        modifier = Modifier.fillMaxWidth().padding(vertical = 8.dp, horizontal = 16.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp, horizontal = 16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = member.name, color = Color.Black,
                style = androidx.compose.ui.text.TextStyle(fontSize = 20.sp)
            )
            Row(
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                OpenUrlIconLinkedIn(member)
                OpenUrlIconGitHub(member)
            }
        }
    }
}

@Composable
fun OpenUrlIconLinkedIn(member: TeamMember) {
    val url = member.linkedInUrl
    val context = LocalContext.current
    IconButton(onClick = {
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
        context.startActivity(intent)
    }) {
        Image(
            painter = painterResource(id = R.drawable.linkedin), // Replace with actual icon resource
            contentDescription = "LinkedIn",
            modifier = Modifier.size(24.dp),

        )
    }
}
@Composable
fun OpenUrlIconGitHub(member: TeamMember) {
    val url = member.githubUrl
    val context = LocalContext.current
    IconButton(onClick = {
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
        context.startActivity(intent)
    }) {
        Image(
            painter = painterResource(id = R.drawable.github), // Replace with actual icon resource
            contentDescription = "GitHub",
            modifier = Modifier.size(24.dp)
        )
    }
}



@Preview(showBackground = true)
@Composable
fun PreviewAboutUsScreen() {
    AboutUsScreen()
}



