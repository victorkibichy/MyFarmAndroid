package com.example.jpapp.UX

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jpapp.R
import androidx.compose.foundation.Image

@Composable
fun VerificationPage() {
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
        Text(
                text = "Equifarm",
                color = Color.Red,
                fontSize = 30.sp
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(
                text = "Enter Verification code",
                modifier = Modifier.padding(horizontal = 16.dp)
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(
                text = "Enter the verification code we just sent you to your email address",
                modifier = Modifier.padding(horizontal = 16.dp)
        )
    }
}