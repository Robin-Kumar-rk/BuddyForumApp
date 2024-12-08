package com.example.buddyforum.ui.theme
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import com.example.buddyforum.R
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem

import androidx.compose.material.ScaffoldState
import androidx.compose.material.rememberScaffoldState
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember

import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.buddyforum.MainViewModel
import com.example.buddyforum.Screen
import com.example.buddyforum.screensInBottomBar

import androidx.compose.material.Scaffold
import androidx.compose.material3.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.IconButton
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.setValue
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.buddyforum.Navigation
import com.example.buddyforum.screensInDrawer
import com.example.buddyforum.screensInTopBar

@OptIn(ExperimentalMaterial3Api::class)
@Composable

fun MainView(
    parentModifier: Modifier = Modifier,
) {

    var expanded by remember { mutableStateOf(false) }
    val scaffoldState: ScaffoldState = rememberScaffoldState()
    val viewModel: MainViewModel = viewModel()
    val navController: NavController = rememberNavController()
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    val currentScreen = remember {
        viewModel.currentScreen.value
    }
    val title = remember { mutableStateOf(currentScreen.title) }
    val bottomBar: @Composable () -> Unit = {
        if (currentScreen is Screen.BottomScreen) {
            BottomNavigation(
                parentModifier.wrapContentSize(),
                backgroundColor = Color.White
            ) {
                screensInBottomBar.forEach { screen ->
                    BottomNavigationItem(
                        selected = currentRoute == screen.route,
                        onClick = {
                            title.value = screen.bottomTitle
                            navController.navigate(screen.bottomRoute)
                        },
                        icon = {
                            Icon(
                                painter = painterResource(id = screen.bottomIcon),
                                contentDescription = screen.bottomTitle,
                                tint = if (currentRoute == screen.bottomRoute) Color.Red
                                else colorResource(R.color.app_bar_color)
                            )
                        },
                        label = {
                            Text(
                                text = screen.bottomTitle,
                                color = if (currentRoute == screen.bottomRoute) Color.Red
                                else colorResource(R.color.app_bar_color),
                                style = TextStyle(
                                    fontSize = 12.sp,         // Reduce the size
                                    fontWeight = FontWeight.Bold, // Increase boldness
                                    letterSpacing = (-0.5).sp  // Reduce space between letters
                                ),
                                maxLines = 1,               // Ensure text stays on one line
                                overflow = TextOverflow.Ellipsis // Add ellipsis if text overflows
                            )
                        },
                    )
                }
            }
        }
    }


    Scaffold(
        scaffoldState = scaffoldState,
        bottomBar = bottomBar,
        topBar = {
            TopAppBar(
                title = { Text(text = title.value, maxLines = 1,
                    overflow = TextOverflow.Ellipsis)  },
                actions = {
                    screensInTopBar.forEach { screen ->
                        IconButton(onClick = {
                            if (screen.topBarRoute != "menu") {
                                title.value = screen.topBarTitle
                                navController.navigate(screen.topBarRoute)
                            } else {
                                expanded = !expanded
                            }
                        }) {
                            Icon(
                                painter = painterResource(id = screen.topBarIcon),
                                contentDescription = screen.topBarTitle,
                                tint = Color.White
                            )
                        }
                    }
                    DropdownMenu(
                        expanded = expanded,
                        onDismissRequest = { expanded = false },
                        modifier = Modifier.width(200.dp).background(Color.White),
                    ) {
                        screensInDrawer.forEach { screen ->
                            DropdownMenuItem(
                                leadingIcon = {
                                    Icon(
                                        painter = painterResource(screen.drawerIcon),
                                        contentDescription = screen.drawerTitle,
                                        tint = colorResource(id = R.color.app_bar_color)
                                    )
                                },
                                text = { Text(screen.drawerTitle, color = colorResource(id = R.color.app_bar_color)) },
                                onClick = {
                                    expanded = false
                                    title.value = screen.drawerTitle
                                    navController.navigate(screen.drawerRoute)
                                }
                            )
                        }
                    }
                },
                navigationIcon = {
                    IconButton(onClick = {}) {
                        Image(
                            painter = painterResource(id = R.drawable.logo),
                            contentDescription = "App Logo", // Provide a meaningful description for accessibility
                            modifier = Modifier.size(100.dp) // Adjust size as needed,

                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = colorResource(id = R.color.app_bar_color),
                    titleContentColor = Color.White,
                    navigationIconContentColor = Color.White,
                )
            )
        },

        floatingActionButton = {
            FloatingActionButton(
                modifier = Modifier.padding(20.dp),
                contentColor = colorResource(id = R.color.app_bar_color),
                containerColor = Color.White,
                shape = RoundedCornerShape(30.dp),
                onClick = { navController.navigate(Screen.ComplaintRegistration.route)}
            ) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = "Add",
                    modifier = Modifier.size(40.dp) // Increase size of the icon
                )
            }
        }
    ) {
        Navigation(
            controller = navController,
            viewModel = viewModel,
            pdd = it
        )
    }

}