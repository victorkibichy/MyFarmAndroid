package com.example.jpapp

import android.annotation.SuppressLint
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.viewinterop.AndroidView
import androidx.navigation.NavController

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun MyFarmScreen(navController: NavController) {
    // Your top bar color setup
    MaterialTheme(
            colors = lightColors(primary = colorResource(id = R.color.maroon))
    ) {
        // Scaffold containing the top bar
        Scaffold(
                topBar = {
                    TopAppBar(
                            title = { Text("My farm") },
                            navigationIcon = {
                                IconButton(onClick = { navController.navigateUp() }) {
                                    Icon(
                                            painter = painterResource(id = R.drawable.ic_arrow_back_foreground),
                                            contentDescription = "Back to Dashboard"
                                    )
                                }
                            },
                            // Add more top bar content as needed
                    )
                }
        ) {
            // MyFarmScreen content
            val url = "https://www.arcgis.com/sharing/rest/oauth2/authorize?client_id=survey123hub&display=default&redirect_uri=https%3A%2F%2Fsurvey123.arcgis.com%2Fsurveys&parent=https://survey123.arcgis.com&locale=en&response_type=token&expiration=720"

            AndroidView(
                    modifier = Modifier.fillMaxSize(),
                    factory = { context ->
                        WebView(context).apply {
                            settings.javaScriptEnabled = true
                            webViewClient = WebViewClient()
                            loadUrl(url)
                        }
                    }
            )
        }
    }
}




