package com.example.buddyforum.ui.theme

import com.example.buddyforum.R



import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

import androidx.compose.ui.res.colorResource

import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NotesScreen() {
    var selectedCourse by remember { mutableStateOf("") }
    var selectedYear by remember { mutableStateOf("") }
    var selectedBranch by remember { mutableStateOf("") }
    var selectedSubject by remember { mutableStateOf("") }
    var showComingSoon by remember { mutableStateOf(false) }

    // State to control the visibility of each dropdown
    var expandedCourse by remember { mutableStateOf(false) }
    var expandedYear by remember { mutableStateOf(false) }
    var expandedBranch by remember { mutableStateOf(false) }
    var expandedSubject by remember { mutableStateOf(false) }

    // Data for dropdowns
    val courses = listOf("B.Tech", "MCA", "B.T.")
    val years = listOf("1st", "2nd", "3rd", "4th")
    val branches = listOf("CSE", "Electrical", "Mechanical", "Civil")
    val subjects = listOf("Mathematics", "Physics", "Computer Science", "Electrical Engineering")
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = colorResource(id = com.example.buddyforum.R.color.app_bar_color)) // This ensures the background color is applied to the screen
    ) {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            // Course Dropdown
            ExposedDropdownMenuBox(
                expanded = expandedCourse,
                onExpandedChange = { expandedCourse = !expandedCourse },
                modifier = Modifier.fillMaxWidth()
            ) {
                OutlinedTextField(
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedTextColor = Color.White,
                        unfocusedTextColor = Color.White
                    ),
                    value = selectedCourse,
                    onValueChange = {},
                    label = { Text("Course", color = Color.White) },
                    trailingIcon = {
                        Icon(
                            imageVector = Icons.Default.ArrowDropDown,
                            contentDescription = "Course Dropdown",
                            tint = Color.White
                        )
                    },
                    readOnly = true,
                    modifier = Modifier
                        .fillMaxWidth()
                        .menuAnchor()
                )
                ExposedDropdownMenu(
                    expanded = expandedCourse,
                    onDismissRequest = { expandedCourse = false },
                    modifier = Modifier.background(Color.White)
                ) {
                    courses.forEach { course ->
                        DropdownMenuItem(
                            text = { Text(course, color = colorResource(id = com.example.buddyforum.R.color.app_bar_color)) },
                            onClick = {
                                selectedCourse = course
                                expandedCourse = false // Close dropdown after selection
                            }
                        )
                    }
                }
            }

            // Year Dropdown
            ExposedDropdownMenuBox(
                expanded = expandedYear,
                onExpandedChange = { expandedYear = !expandedYear },
                modifier = Modifier.fillMaxWidth()
            ) {
                OutlinedTextField(
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedTextColor = Color.White,
                        unfocusedTextColor = Color.White
                    ),
                    value = selectedYear,
                    onValueChange = {},
                    label = { Text("Year", color = Color.White) },
                    trailingIcon = {
                        Icon(
                            imageVector = Icons.Default.ArrowDropDown,
                            contentDescription = "Year Dropdown",
                            tint = Color.White
                        )
                    },
                    readOnly = true,
                    modifier = Modifier
                        .fillMaxWidth()
                        .menuAnchor()
                )
                ExposedDropdownMenu(
                    expanded = expandedYear,
                    onDismissRequest = { expandedYear = false },
                    modifier = Modifier.background(Color.White)
                ) {
                    years.forEach { year ->
                        DropdownMenuItem(
                            text = { Text(year, color = colorResource(id = com.example.buddyforum.R.color.app_bar_color)) },
                            onClick = {
                                selectedYear = year
                                expandedYear = false // Close dropdown after selection
                            }
                        )
                    }
                }
            }

            // Branch Dropdown
            ExposedDropdownMenuBox(
                expanded = expandedBranch,
                onExpandedChange = { expandedBranch = !expandedBranch },
                modifier = Modifier.fillMaxWidth()

            ) {
                OutlinedTextField(
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedTextColor = Color.White,
                        unfocusedTextColor = Color.White
                    ),
                    value = selectedBranch,
                    onValueChange = {},
                    label = { Text("Branch", color = Color.White) },
                    trailingIcon = {
                        Icon(
                            imageVector = Icons.Default.ArrowDropDown,
                            contentDescription = "Branch Dropdown"
                            , tint = Color.White

                        )
                    },
                    readOnly = true,
                    modifier = Modifier
                        .fillMaxWidth()
                        .menuAnchor()
                )
                ExposedDropdownMenu(
                    expanded = expandedBranch,
                    onDismissRequest = { expandedBranch = false },
                    modifier = Modifier.background(Color.White)
                ) {
                    branches.forEach { branch ->
                        DropdownMenuItem(
                            text = { Text(branch, color = colorResource(id = com.example.buddyforum.R.color.app_bar_color)) },
                            onClick = {
                                selectedBranch = branch
                                expandedBranch = false // Close dropdown after selection
                            }
                        )
                    }
                }
            }

            // Subject Dropdown
            ExposedDropdownMenuBox(
                expanded = expandedSubject,
                onExpandedChange = { expandedSubject = !expandedSubject },
                modifier = Modifier.fillMaxWidth()
            ) {
                OutlinedTextField(
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedTextColor = Color.White,
                        unfocusedTextColor = Color.White
                    ),
                    value = selectedSubject,
                    onValueChange = {},
                    label = { Text("Subject", color = Color.White) },
                    trailingIcon = {
                        Icon(
                            imageVector = Icons.Default.ArrowDropDown,
                            contentDescription = "Subject Dropdown",
                            tint = Color.White
                        )
                    },
                    readOnly = true,
                    modifier = Modifier
                        .fillMaxWidth()
                        .menuAnchor()
                )
                ExposedDropdownMenu(
                    expanded = expandedSubject,
                    onDismissRequest = { expandedSubject = false },
                    modifier = Modifier.background(Color.White)
                ) {
                    subjects.forEach { subject ->
                        DropdownMenuItem(
                            text = { Text(subject, color = colorResource(id = com.example.buddyforum.R.color.app_bar_color)) },
                            onClick = {
                                selectedSubject = subject
                                expandedSubject = false // Close dropdown after selection
                            }
                        )
                    }
                }
            }

            // Search Button
            Button(
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.White,
                    contentColor = colorResource(id = R.color.app_bar_color)
                ),
                onClick = {
                    showComingSoon = true
                },
                modifier = Modifier.align(Alignment.CenterHorizontally)
            ) {
                Text("Search", fontSize = 16.sp)
            }

            // Show "Coming Soon" message
            if (showComingSoon) {
                Text(
                    text = "Coming Soon..., We are Sorry.",
                    fontSize = 16.sp,
                    color = Color.White,
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                )
            }
        }
    }
}


