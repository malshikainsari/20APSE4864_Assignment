package com.example.assignment.navigation

import androidx.compose.runtime.*
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.compose.*
import com.example.assignment.data.AppDatabase
import com.example.assignment.screens.*

@Composable
fun Navigation() {

    val context = LocalContext.current

    val db = remember {
        AppDatabase.getDatabase(context)
    }

    val userDao = db.userDao()

    val navController = rememberNavController()

    var username by remember {
        mutableStateOf("")
    }

    NavHost(
        navController = navController,
        startDestination = "login"
    ) {

        composable("login") {

            LoginScreen(
                userDao = userDao,

                onLoginSuccess = {

                    username = it

                    navController.navigate("home")
                },

                onRegisterClick = {
                    navController.navigate("register")
                }
            )
        }

        composable("register") {

            RegisterScreen(
                userDao = userDao,

                onRegisterSuccess = {
                    navController.navigate("login")
                }
            )
        }

        composable("home") {

            HomeScreen(

                username = username,

                onLogout = {
                    navController.navigate("login")
                }
            )
        }
    }
}