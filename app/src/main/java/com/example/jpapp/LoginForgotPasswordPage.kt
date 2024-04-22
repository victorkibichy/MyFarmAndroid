package com.example.jpapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

    @Composable
    fun LoginForgotPasswordPage(navController: NavController, isResettingPassword: Boolean = false) {
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Image(
                painter = painterResource(id = R.drawable.equitylogo),
                contentDescription = null,
                modifier = Modifier.padding(vertical = 16.dp)
            )
            UsernameField()
            Spacer(modifier = Modifier.height(16.dp))
            PasswordField()
            Spacer(modifier = Modifier.height(16.dp))
            LoginButton(onClick = {
                navController.navigate("create_password")
            }
            )
        }
    }

