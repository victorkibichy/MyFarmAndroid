package com.example.jpapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

@Composable
fun ToolCard(
    imageResource: Int,
    toolName: String,
    sellerName: String,
    price: String,
    availability: String
){
    Card(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth(),
        elevation = 8.dp
    ) {
        Column(
            modifier = Modifier
                .padding(8.dp)
        ) {
            Image(
                painter = painterResource(id = imageResource),
                contentDescription = null,
                modifier = Modifier
                    .height(200.dp)
                    .fillMaxWidth()
                    .clip(shape = MaterialTheme.shapes.medium),
                contentScale = ContentScale.Crop
            )

            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = toolName,
                style = MaterialTheme.typography.h6,
                modifier = Modifier.fillMaxWidth()
            )

            Text(
                text = "Seller: $sellerName",
                style = MaterialTheme.typography.body1,
                modifier = Modifier.fillMaxWidth()
            )

            Text(
                text = "Price: $price",
                style = MaterialTheme.typography.body1,
                modifier = Modifier.fillMaxWidth()
            )

            Text(
                text = "Availability: $availability",
                style = MaterialTheme.typography.body1,
                modifier = Modifier.fillMaxWidth()
            )
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                IconButton(onClick = { }) {
                    Icon(Icons.Filled.ShoppingCart, contentDescription = "Add to Cart")
                }

                IconButton(onClick = { }) {
                    Icon(Icons.Filled.Favorite, contentDescription = "Favorite")
                }
            }
        }
    }
}

