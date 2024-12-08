package com.example.buddyforum.ui.theme

import androidx.compose.foundation.lazy.items
import com.example.buddyforum.Complaint
import com.example.buddyforum.R
import com.example.buddyforum.Severity


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding

import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ThumbUp
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember


import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment

import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow

import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun ComplaintItem(
    complaint: Complaint,
    onUpvoteClick: (Complaint) -> Unit // Callback when upvote is clicked
) {
    var isExpanded by remember { mutableStateOf(false) } // State for expanding/collapsing description

    Card(
        colors = CardDefaults.cardColors(containerColor = Color(0xFFD9CCF5)),
        modifier = Modifier
            .fillMaxWidth()
            .padding(4.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Column(modifier = Modifier.padding(vertical = 8.dp, horizontal = 16.dp)) {
            // Title centered
            Box(
                modifier = Modifier.fillMaxWidth(),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = complaint.title,
                    color = Color(0xFF9C23E7),
                    fontWeight = FontWeight.Bold,
                    fontSize = 24.sp,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
            }

            Spacer(modifier = Modifier.height(4.dp))

            // Severity and Category Row
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = complaint.severity.name,

                    color = when (complaint.severity) {
                        Severity.MAJOR -> Color.Red
                        Severity.MODERATE -> Color.Yellow
                        Severity.MINOR -> Color.Green
                    }
                )
                if (complaint.category != "") {
                    Text(
                        text = complaint.category, // Replace with actual category if available
                        color = Color(0xFF0390F6)
                    )
                }
            }

            Spacer(modifier = Modifier.height(4.dp))

            // Description
            Text(
                text = if (isExpanded) complaint.description else "${complaint.description.take(50)}..",
                color = Color.Black
            )
            if (complaint.description.length > 50) {
                TextButton(onClick = { isExpanded = !isExpanded }) {
                    Text(if (isExpanded) "Read less" else "Read more", color = Color(0xFF035CF6))
                }
            }

//            // Image (Visible when expanded)
//            if (isExpanded && complaint.image != null) {
//                Spacer(modifier = Modifier.height(4.dp))
//                Image(
//                    painter = rememberAsyncImagePainter(model = complaint.image),
//                    contentDescription = "Complaint Image",
//                    modifier = Modifier
//                        .fillMaxWidth()
//                        .height(200.dp)
//                        .clip(RoundedCornerShape(8.dp))
//                )
//            }

//            Spacer(modifier = Modifier.height(4.dp))

            // Upvote Button
            Row(verticalAlignment = Alignment.CenterVertically) {
                Button(
                    onClick = { onUpvoteClick(complaint) },
                    colors = ButtonDefaults.buttonColors(
                        contentColor = if (complaint.upvoted) Color(0xFF8DC6EF) else Color.White,
                        containerColor = Color(0xFF515556)
                    ),
//                    modifier = Modifier.size(20.dp)
                ) {
                    Icon(
                        imageVector = Icons.Default.ThumbUp,
                        contentDescription = "Upvote"
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    Text(text = "(${complaint.upvote})")
                }
            }
        }
    }
}

@Composable
fun HomeView(
    complaints: List<Complaint>,
    onUpvoteClick: (Complaint) -> Unit
) {
    LazyColumn(modifier = Modifier.fillMaxSize().background(color = colorResource(id = R.color.app_bar_color))) {
        items(complaints) { complaint -> // Ensure complaints is a List
            ComplaintItem(
                complaint = complaint,
                onUpvoteClick = onUpvoteClick
            )
        }
    }
}


