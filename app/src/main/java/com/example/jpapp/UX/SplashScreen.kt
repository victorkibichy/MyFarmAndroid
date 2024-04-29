package com.example.jpapp.UX
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.jpapp.R
import kotlinx.coroutines.delay


@Composable
fun SplashScreen(navController: NavController) {
    LaunchedEffect(key1 = true) {
        // Delay for 2 seconds
        delay(2000)
        // Navigate to the login page after the delay
        navController.navigate("sign in")
    }

    Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
                painter = painterResource(id = R.drawable.equitylogo),
                contentDescription = null,
                modifier = Modifier.padding(vertical = 18.dp)
        )

    }
}

