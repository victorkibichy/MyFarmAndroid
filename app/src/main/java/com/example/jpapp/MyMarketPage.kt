package com.example.jpapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import java.time.LocalDate

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyMarketPage(navController: NavController) {
        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Add a top app bar with "My Market" heading
            item {
                TopAppBar(
                    title = {
                        Text(text = "My Market")
                    },
                    modifier = Modifier.padding(top = 0.dp)
                )
            }

            // Add an image
            item {
                Image(
                    painter = painterResource(id = R.drawable.tomatoes),
                    contentDescription = null,
                    modifier = Modifier
                        .padding(vertical = 60.dp)
                        .size(400.dp)
                )
            }

            // Add text below the image
            item {
                Column(
                    modifier = Modifier.padding(horizontal = 16.dp)
                ) {
                    Text(
                        text = "Fresh Tomatoes for Sale",
                        fontWeight = FontWeight.Bold,
                        fontSize = 24.sp,
                        modifier = Modifier.padding(bottom = 8.dp)
                    )
                    Text(
                        text = "Qty: 24kgs\nPrice: 135/kg\nAvailable Date: ${LocalDate.now()}",
                        fontWeight = FontWeight.Bold,
                        fontSize = 18.sp
                    )
                }
            }

            // Floating action button for adding new farm produce
            item {
                FloatingActionButton(
                    onClick = {
                        navController.navigate("newFarmProduce")
                    },
                    modifier = Modifier
                        .padding(16.dp)

                ) {
                    Icon(Icons.Filled.Add, contentDescription = "Add")
                }
            }

            // Your My Market page content goes here
        }
    }

