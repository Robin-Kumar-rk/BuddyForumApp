package com.example.buddyforum

import androidx.annotation.DrawableRes

sealed class Screen(val title: String, val route: String) {
    sealed class BottomScreen(
        val bottomTitle: String,
        val bottomRoute: String,
        @DrawableRes val bottomIcon: Int
    ): Screen(bottomTitle, bottomRoute) {
        object Home: BottomScreen("Home", "home", R.drawable.baseline_home_24)
        object MyComplaints: BottomScreen("My Complaints", "my_complaints", R.drawable.baseline_playlist_add_24)
        object Notes: BottomScreen("Notes", "notes", R.drawable.baseline_edit_note_24)
    }

    sealed class DrawerScreen(
        val drawerTitle: String,
        val drawerRoute: String,
        @DrawableRes val drawerIcon: Int
    ): Screen(drawerTitle, drawerRoute) {
        object Settings: DrawerScreen("Settings", "settings", R.drawable.baseline_settings_24)
        object About: DrawerScreen("Team", "about", R.drawable.baseline_info_24)
        object Contact: DrawerScreen("Contact Us", "contact_us", R.drawable.baseline_account_box_24)
        object Roadmap: DrawerScreen("Roadmap", "roadmap", R.drawable.baseline_location_pin_24)
    }

    sealed class TopBarScreen(
        val topBarTitle: String,
        val topBarRoute: String,
        @DrawableRes val topBarIcon: Int
    ): Screen(topBarTitle, topBarRoute) {
        object Notification: TopBarScreen("Notifications", "notifications", R.drawable.baseline_notifications_24)
        object User: TopBarScreen("Log In", "user", R.drawable.baseline_account_circle_24)
        object Menu: TopBarScreen("Menu", "menu", R.drawable.baseline_more_vert_24)
    }

    object ComplaintRegistration: Screen("Complaint Registration", "complaint_registration")
    object SignUp: Screen("Sign Up", "sign_up")
}
val screensInBottomBar = listOf(
    Screen.BottomScreen.Home,
    Screen.BottomScreen.MyComplaints,
    Screen.BottomScreen.Notes
)
val screensInDrawer = listOf(
    Screen.DrawerScreen.Settings,
    Screen.DrawerScreen.About,
    Screen.DrawerScreen.Contact,
    Screen.DrawerScreen.Roadmap
)
val screensInTopBar = listOf(
    Screen.TopBarScreen.Notification,
    Screen.TopBarScreen.User,
    Screen.TopBarScreen.Menu
)