package com.example.assignment.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun HomeScreen(
    username: String,
    onLogout: () -> Unit
) {

    Column(
        modifier = Modifier.padding(20.dp)
    ) {

        Text(
            text = "Welcome $username"
        )

        Spacer(
            modifier = Modifier.height(20.dp)
        )

        Button(
            onClick = onLogout
        ) {
            Text("Logout")
        }
    }
}
