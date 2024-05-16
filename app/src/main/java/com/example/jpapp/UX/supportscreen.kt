package com.example.jpapp.UX

import android.annotation.SuppressLint
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material3.Surface
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.dp

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun SupportScreen(navController: NavController) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Support") }
            )
        }
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxSize()
        ) {
            SupportBox(
                text = "Activate Chat\nTransact with virtual assistant",
                icon = Icons.Default.ArrowForward,
                onClick = { navController.navigate("destination1") }
            )
            Spacer(modifier = Modifier.height(16.dp))
            SupportBox(
                text = "Get in touch\nEmail, call or find us on social media",
                icon = Icons.Default.ArrowForward,
                onClick = { navController.navigate("destination2") }
            )
        }
    }
}

@Composable
fun SupportBox(text: String, icon: ImageVector, onClick: () -> Unit) {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .height(100.dp) // Reduced height to 100dp
            .padding(8.dp)
            .clickable(onClick = onClick), // Making the entire surface clickable
        color = Color.Gray // Changed background color to gray
    ) {
        Row(
            modifier = Modifier.padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(text)
            Spacer(modifier = Modifier.weight(1f))
            Icon(
                imageVector = icon,
                contentDescription = "Forward Arrow"
            )
        }
    }
}
