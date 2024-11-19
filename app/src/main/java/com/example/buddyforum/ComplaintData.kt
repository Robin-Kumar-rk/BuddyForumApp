package com.example.buddyforum

import androidx.compose.runtime.mutableStateListOf

val complaintList = mutableStateListOf(
    Complaint(
        id = 1,
        title = "Broken Window in Library",
        description = "The library window on the second floor is broken and poses a safety hazard. Needs immediate attention.",
        image = null,
        upvote = 12,
        category = "Infrastructure"
    ),
    Complaint(
        id = 2,
        title = "Wi-Fi Not Working",
        description = "The Wi-Fi in the main building has been down for two days. Students are unable to complete their assignments.",
        image = null,
        upvote = 8,
        category = "Facility"

    )
)
val myComplaintList = mutableStateListOf<Complaint>()




