     package com.example.jpapp.UX

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.compose.material.icons.filled.ShoppingCart


@Composable
fun ImageCard(imageResId: Int, onAddToCart: () -> Unit, onFavorite: () -> Unit, navController: NavController) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .clickable { /* Navigate to detail page if needed */ },
            elevation = 4.dp
        ) {
            Column {
                Image(
                    painter = painterResource(id = imageResId),
                    contentDescription = "Farm machinery",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(200.dp)
                )
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.End
                ) {
                    IconButton(onClick = onAddToCart) {
                        Icon(Icons.Filled.ShoppingCart, contentDescription = "Add to cart")
                    }
                    IconButton(onClick = onFavorite) {
                        Icon(Icons.Filled.Favorite, contentDescription = "Favorite")
                    }
                }
            }
        }
    }
    