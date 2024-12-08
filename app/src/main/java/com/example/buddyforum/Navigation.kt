package com.example.buddyforum

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

import com.example.buddyforum.ui.theme.*
@Composable

fun Navigation(
    controller: NavController,
    viewModel: MainViewModel,
    pdd: PaddingValues
) {

    val context = LocalContext.current
    NavHost(
        navController = controller as NavHostController,
        startDestination = Screen.BottomScreen.Home.bottomRoute,
        modifier = Modifier.padding(pdd)
    ) {
        composable(Screen.BottomScreen.Home.bottomRoute) {
            HomeView(complaintList) { updateUpvote(it.id) }
        }
        composable(Screen.BottomScreen.MyComplaints.bottomRoute) {
            HomeView(myComplaintList) { updateUpvote(it.id) }
        }

        composable(Screen.BottomScreen.Notes.bottomRoute) {
            NotesScreen()
        }

        composable(Screen.DrawerScreen.About.drawerRoute) {
            AboutUsScreen()
        }

        composable(Screen.DrawerScreen.Contact.drawerRoute) {
            ContactUsScreen{controller.navigate(Screen.BottomScreen.Home.bottomRoute)}
        }

        composable(Screen.DrawerScreen.Settings.drawerRoute) {
            SettingView()
        }

        composable(Screen.DrawerScreen.Roadmap.drawerRoute) {
            RoadMapScreen { controller.navigate(Screen.BottomScreen.Home.bottomRoute) }
        }

        composable(Screen.TopBarScreen.Notification.topBarRoute) {
            NotificationsView()
        }

        composable(Screen.TopBarScreen.User.topBarRoute) {
            LoginScreen(navController = controller)
        }

        composable(Screen.SignUp.route) {
            SignUpScreen(navController = controller)
        }

        composable(Screen.ComplaintRegistration.route) {
            ComplaintRegistrationScreen(navController = controller)
        }
    }
    BackHandler {
        // Navigate to HomeView on back press
        if (controller.currentDestination?.route != Screen.BottomScreen.Home.bottomRoute) {
            controller.navigate(Screen.BottomScreen.Home.bottomRoute) {
                popUpTo(Screen.BottomScreen.Home.bottomRoute) { inclusive = true }
            }
        } else {
            // If already on HomeView, perform default back action (exit the app)
            (context as? android.app.Activity)?.finish()
        }
    }
}

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