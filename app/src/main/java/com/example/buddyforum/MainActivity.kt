package com.example.buddyforum

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.res.colorResource
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.buddyforum.ui.theme.BuddyForumTheme
import androidx.appcompat.app.AppCompatDelegate


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
            BuddyForumTheme {
                val navController = rememberNavController()
                NavHost(navController = navController, startDestination = "main screen") {
                    composable(route = "main screen") {
                        AppContent(
                            onNavigateToLoginScreen = { navController.navigate("login screen") },
                            onNavigateToComplaintScreen = { navController.navigate("complaint screen") },
                            onNavigateToMainScreen = { navController.navigate("main screen") }
                        )
                    }
                    composable(route = "login screen") {
                        LoginScreen(
                            onNavigateToMainScreen = { navController.navigate("main screen") },
                            onNavigateToSignUpScreen = { navController.navigate("signup screen") }
                        )
                    }
                    composable(route = "signup screen") {
                        SignUpScreen(
                            onNavigateToMainScreen = {navController.navigate("main screen")},
                            onNavigateToLoginScreen = {navController.navigate("login screen")}
                        )
                    }
                    composable(route = "complaint screen") {
                        ComplaintRegistrationScreen(
                            onSubmitComplaint = {title, description, category ->
                                if (!title.isEmpty() && !description.isEmpty()) {
                                    val newComplaint = Complaint(
                                        id = complaintList.size + 1,
                                        title = title,
                                        description= description,
                                        category = if (category == "Select Category") "" else category
                                    )
                                    complaintList.add(newComplaint)
                                    myComplaintList.add(newComplaint)
                                }

                            },
                            onNavigateToMainScreen = {navController.navigate("main screen")}
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun AppContent(
    onNavigateToLoginScreen: () -> Unit,
    onNavigateToComplaintScreen: () -> Unit,
    onNavigateToMainScreen: () -> Unit
) {

    var bottomSelection by remember { mutableStateOf(0) }
    Scaffold(
        topBar = {
            ForumTopAppBar(
                onNotificationClick = {},
                onNavigateToLoginScreen = onNavigateToLoginScreen,
                onAboutClick = { bottomSelection = 3 },
                onContactClick = { bottomSelection = 4} ,
                onRoadmapClick = {bottomSelection = 5}
            )
        },
        bottomBar = {
            ForumBottomAppBar(
                onHomeClick = { bottomSelection = 0 },
                onMyComplaintClick = { bottomSelection = 1 },
                onNotesClick = { bottomSelection = 2 }
            )
        },
        floatingActionButton = {
            FloatingActionButton(
                modifier = Modifier.padding(20.dp),
                contentColor = colorResource(id = R.color.app_bar_color),
                containerColor = Color.White,
                shape = RoundedCornerShape(30.dp),
                onClick = onNavigateToComplaintScreen
            ) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = "Add",
                    modifier = Modifier.size(40.dp) // Increase size of the icon
                )
            }
        }
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            contentAlignment = Alignment.Center
        ) {
            if (bottomSelection == 0) {
                ComplaintsList(
                    complaints = complaintList,
                    onUpvoteClick = {
                        updateUpvote(it.id)
                    }
                )
            } else if (bottomSelection == 1) {
                ComplaintsList(
                    complaints = myComplaintList,
                    onUpvoteClick = {
                        updateUpvote(it.id)
                    }
                )
            } else if (bottomSelection == 2) {
                NotesScreen()
            } else if (bottomSelection == 3) {
                TeamInfo()
            } else if (bottomSelection == 4) {
                ContactUs(onSendClick = {bottomSelection = 0})
            } else if (bottomSelection == 5) {
                FourQuadrants(onNavigateToMainScreen)
            }

        }
    }
}
// Update the upvote of a specific complaint
fun updateUpvote(complaintId: Int) {
    var index = complaintList.indexOfFirst { it.id == complaintId }
    if (index != -1) {
        val newUpvote = if (complaintList[index].upvoted) complaintList[index].upvote - 1 else complaintList[index].upvote + 1
        complaintList[index] = complaintList[index].copy(upvote = newUpvote, upvoted = !complaintList[index].upvoted)
    }

    index = myComplaintList.indexOfFirst { it.id == complaintId }
    if (index != -1) {
        val newUpvote = if (myComplaintList[index].upvoted) myComplaintList[index].upvote - 1 else myComplaintList[index].upvote + 1
        myComplaintList[index] = myComplaintList[index].copy(upvote = newUpvote, upvoted = !myComplaintList[index].upvoted)
    }
}





