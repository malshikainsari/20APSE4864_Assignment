package com.example.assignment.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.assignment.data.User
import com.example.assignment.data.UserDao
import kotlinx.coroutines.launch

@Composable
fun RegisterScreen(
    userDao: UserDao,
    onRegisterSuccess: () -> Unit
) {

    var username by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var message by remember { mutableStateOf("") }

    val scope = rememberCoroutineScope()

    Column(
        modifier = Modifier.padding(20.dp)
    ) {

        Text("Register")

        Spacer(modifier = Modifier.height(10.dp))

        TextField(
            value = username,
            onValueChange = { username = it },
            label = { Text("Username") }
        )

        Spacer(modifier = Modifier.height(10.dp))

        TextField(
            value = email,
            onValueChange = { email = it },
            label = { Text("Email") }
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

                if (
                    username.isEmpty() ||
                    email.isEmpty() ||
                    password.isEmpty()
                ) {
                    message = "Fill all fields"
                } else {

                    scope.launch {

                        userDao.insert(
                            User(
                                username = username,
                                email = email,
                                password = password
                            )
                        )

                        message = "Registration Success"

                        onRegisterSuccess()
                    }
                }
            }
        ) {
            Text("Register")
        }

        Text(message)
    }
}
