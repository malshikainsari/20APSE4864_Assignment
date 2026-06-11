package com.example.assignment.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.assignment.data.UserDao
import kotlinx.coroutines.launch

@Composable
fun LoginScreen(
    userDao: UserDao,
    onLoginSuccess: (String) -> Unit,
    onRegisterClick: () -> Unit
) {

    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var message by remember { mutableStateOf("") }

    val scope = rememberCoroutineScope()

    Column(
        modifier = Modifier.padding(20.dp)
    ) {

        Text("Login")

        Spacer(modifier = Modifier.height(10.dp))

        TextField(
            value = username,
            onValueChange = { username = it },
            label = { Text("Username") }
        )

        Spacer(modifier = Modifier.height(10.dp))

        TextField(
            value = password,
            onValueChange = { password = it },
            label = { Text("Password") }
        )

        Spacer(modifier = Modifier.height(10.dp))

        Button(
            onClick = {
                scope.launch {

                    val user =
                        userDao.login(username, password)

                    if (user != null) {
                        onLoginSuccess(username)
                    } else {
                        message = "Invalid Username or Password"
                    }
                }
            }
        ) {
            Text("Login")
        }

        Text(message)

        TextButton(
            onClick = onRegisterClick
        ) {
            Text("Register")
        }
    }
}
