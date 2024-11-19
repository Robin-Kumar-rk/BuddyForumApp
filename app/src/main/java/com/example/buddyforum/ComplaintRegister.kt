package com.example.buddyforum

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable

import androidx.compose.material3.Icon
import androidx.compose.foundation.layout.Column

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding

import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions

import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue

import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.unit.dp
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown

import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight

import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import kotlin.math.exp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ComplaintRegistrationScreen(
    onSubmitComplaint: (String, String, String) -> Unit, // Callback to handle complaint submission
//    onSelectMedia: () -> Unit // Callback for selecting media
    onNavigateToMainScreen: () -> Unit
) {
    var expanded by remember { mutableStateOf(false) }
    var complaintTitle by remember { mutableStateOf("") }
    var complaintDescription by remember { mutableStateOf("") }
    var selectedCategory by remember { mutableStateOf("Select Category") }
    var mediaUri by remember { mutableStateOf<String?>(null) }

    val categories = listOf("Academic", "Infrastructure", "Facility",  "Class Room","Others",)


    val keyboardController = LocalSoftwareKeyboardController.current
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = colorResource(id = R.color.app_bar_color)) // This ensures the background color is applied to the screen
    ) {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Complaint Title/Description
            Text("Complaint Registration", color = Color.White, fontWeight = FontWeight.Bold, fontSize = 24.sp)

            Spacer(modifier = Modifier.height(16.dp))

            // Title Field (complaint title)
            OutlinedTextField(
                colors = OutlinedTextFieldDefaults.colors(
                    focusedTextColor = Color.White,
                    unfocusedTextColor = Color.White
                ),
                value = complaintTitle,
                onValueChange = { complaintTitle = it },
                label = { Text("Complaint Title", color = Color.White) },
                modifier = Modifier.fillMaxWidth(),
                singleLine = true
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Description Field
            OutlinedTextField(
                colors = OutlinedTextFieldDefaults.colors(
                    focusedTextColor = Color.White,
                    unfocusedTextColor = Color.White
                ),
                value = complaintDescription,
                onValueChange = { complaintDescription = it },
                label = { Text("Complaint Description", color = Color.White) },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(150.dp),
                keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Text),
                keyboardActions = KeyboardActions(onDone = { keyboardController?.hide() })
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Category Dropdown (DropdownMenu)
            ExposedDropdownMenuBox(
                expanded = expanded,
                onExpandedChange = { expanded = !expanded },
                modifier = Modifier.fillMaxWidth()
            ) {
                OutlinedTextField(
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedTextColor = Color.White,
                        unfocusedTextColor = Color.White
                    ),
                    value = selectedCategory,
                    onValueChange = {},
                    label = { Text("Category" , color = Color.White) },
                    trailingIcon = {
                        Icon(
                            imageVector = Icons.Default.ArrowDropDown,
                            contentDescription = "Category Dropdown"
                        )
                    },
                    readOnly = true,
                    modifier = Modifier
                        .fillMaxWidth()
                        .menuAnchor()
                )

                // Dropdown menu items
                ExposedDropdownMenu(
                    expanded = expanded,
                    onDismissRequest = { expanded = !expanded }
                ) {
                    categories.forEach { category ->
                        DropdownMenuItem(
                            text = { Text(text = category) },
                            onClick = {
                                selectedCategory = category
                                expanded = !expanded
                            }
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            AddImageButton()

            Spacer(modifier = Modifier.height(16.dp))

            // Submit Complaint Button
            Button(
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.White,
                    contentColor = colorResource(id = R.color.app_bar_color)
                ),
                onClick = {
                    onSubmitComplaint(complaintTitle, complaintDescription, selectedCategory)
                    keyboardController?.hide() // Hide the keyboard after submission
                    onNavigateToMainScreen()
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Submit Complaint", fontSize = 16.sp)
            }
        }
    }
}

//@Preview(showBackground = true)
//@Composable
//fun ComplaintRegistrationScreenPreview() {
//    // Providing dummy implementations for the callbacks
//    ComplaintRegistrationScreen(
////        onSubmitComplaint = { title, description, category ->
////            // Just logging the values for preview
////            println("Complaint Submitted: Title: $title, Description: $description, Category: $category")
////        },
////        onSelectMedia = {
////            // Logging media selection action for preview
////            println("Media selected")
////        }
//    )
//}

