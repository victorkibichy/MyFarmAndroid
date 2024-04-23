package com.example.jpapp

import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.viewinterop.AndroidView

@Composable
fun MyFarmScreen() {
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



