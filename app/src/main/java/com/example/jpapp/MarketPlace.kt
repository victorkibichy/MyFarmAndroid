@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.jpapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.layout.ContentScale
import androidx.navigation.NavHostController


@Composable
fun Marketplace(navController: NavHostController) {
    Surface(
        color = Color.LightGray,
    ) {
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            TopAppBar(
                title = {
                    Text(
                        text = "Equifarm",
                        color = Color.Black, // Set text color of Equifarm to black
                        modifier = Modifier.fillMaxWidth(),
                    )
                },
            )
            // Horizontal scrolling buttons
            LazyRow(
                modifier = Modifier.padding(start = 16.dp, end = 16.dp, bottom = 8.dp)
            ) {
                item { CategoryButton(text = "All") }
                item { CategoryButton(text = "Cereals") }
                item { CategoryButton(text = "Fruits") }
                item { CategoryButton(text = "Poultry") }
                item { CategoryButton(text = "Vegetables") }
                item { CategoryButton(text = "Legumes") }
                item { CategoryButton(text = "Dairy") }
            }

            LazyColumn(
                modifier = Modifier.weight(1f)
            ) {
                // com.example.jpapp.Marketplace content
                items(6) { index ->
                    Row(
                        modifier = Modifier
                            .padding(16.dp)
                            .fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        when (index) {
                            1 -> {
                                // First Card with image
                                Surface(
                                    modifier = Modifier
                                        .weight(1f)
                                        .padding(end = 8.dp)
                                        .fillMaxHeight()
                                        .height(200.dp),
                                    color = Color.Gray
                                ) {
                                    // Image added here
                                    CardWithImage("Card 1", painterResource(id = R.drawable.oranges))
                                }
                            }
                            1 -> {
                                // Second Card with a different image
                                Surface(
                                    modifier = Modifier
                                        .weight(1f)
                                        .padding(end = 8.dp)
                                        .fillMaxHeight()
                                        .height(200.dp),
                                    color = Color.Gray
                                ) {
                                    // Different image added here
                                    CardWithImage(
                                        "Card 2",
                                        painterResource(id = R.drawable.passionfruits)
                                    )
                                }
                            }
                            else -> {
                                // Other Cards without image
                                Surface(
                                    modifier = Modifier
                                        .weight(1f)
                                        .padding(end = 8.dp)
                                        .fillMaxHeight()
                                        .height(200.dp),
                                    color = Color.Gray
                                ) {
                                    CardWithImage("Card $index", painterResource(id = R.drawable.cabbages))
                                }
                            }
                        }

                        Surface(
                            modifier = Modifier
                                .weight(1f)
                                .padding(start = 8.dp)
                                .fillMaxHeight()
                                .height(200.dp),
                            color = Color.Gray
                        ) {
                            CardWithImage("Card ${index + 3}", painterResource(id = R.drawable.cucumbers))
                        }
                    }
                }
            }
        }
    }
}
@Composable
fun CardContent(text: String) {
    Text(
        text = text,
        color = Color.Black,
        modifier = Modifier.padding(16.dp)
    )
}

@Composable
fun CardWithImage(text: String, imagePainter: Painter) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
    ) {
        Box(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth()
        ) {
            Image(
                painter = imagePainter,
                contentDescription = null,
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.FillHeight
            )
        }
        Box(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 8.dp)
        ) {
            Text(
                text = text,
                color = Color.Black,
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}

@Composable
fun CategoryButton(text: String) {
    Surface(
        modifier = Modifier.padding(horizontal = 8.dp),
        color = Color.White.copy(alpha = 0.5f),
        contentColor = Color.Black,
    ) {
        Text(
            text = text,
            modifier = Modifier.padding(12.dp)
        )
    }
}
