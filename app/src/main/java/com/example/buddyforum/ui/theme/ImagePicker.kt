package com.example.buddyforum.ui.theme

import com.example.buddyforum.R



import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult

import androidx.activity.result.contract.ActivityResultContracts

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer

import androidx.compose.foundation.layout.height


import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

import androidx.compose.ui.unit.dp
import androidx.compose.ui.platform.LocalContext
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import android.net.Uri
import androidx.compose.foundation.layout.*
import androidx.compose.material3.ButtonDefaults
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.sp


@Composable
fun AddImageButton() {
    // State to store the URI of the selected image
    var mediaUri by remember { mutableStateOf<Uri?>(null) }
    val context = LocalContext.current
    // Launcher for image picker intent
    val pickImageLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetContent(),
        onResult = { uri ->
            // Handle the selected URI (image)
            mediaUri = uri
            // Optionally, display a toast message
            uri?.let {
                Toast.makeText(context, "Image selected: $uri", Toast.LENGTH_SHORT).show()
            }
        }
    )

    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Button to trigger image picker
        Button(
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.White,
                contentColor = colorResource(id = R.color.app_bar_color)
            ),
            onClick = {
                // Launch the image picker when the button is clicked
                pickImageLauncher.launch("image/*")
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "Add Image", fontSize = 16.sp)
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Display selected image URI if available
        mediaUri?.let {
            Text("Selected Media: $it")
        }
    }
}
