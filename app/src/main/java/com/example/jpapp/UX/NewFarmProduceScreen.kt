package com.example.jpapp.UX

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NewFarmProduceScreen(navController: NavController) {
        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally

        ) {
            // Add a top app bar with "New Farm Produce" heading
            item {
                TopAppBar(
                    title = {
                        Text(text = "New Farm Produce")
                    },
                    modifier = Modifier.padding(top = 0.dp)

                )
            }

            // Add "Select Category" dropdown menu
            item {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 16.dp)
                        .padding(horizontal = 16.dp)

                ) {
                    var expandedCategory by remember { mutableStateOf(false) }
                    var selectedCategory by remember { mutableStateOf("Select Category") }
                    val categories = listOf("Fruits", "Cereals", "Poultry", "Vegetables", "Legumes", "Dairy")

                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Text(selectedCategory, Modifier.weight(1f))
                        Icon(
                            imageVector = Icons.Default.ArrowDropDown,
                            contentDescription = "Dropdown Icon",
                            modifier = Modifier.clickable(onClick = { expandedCategory = !expandedCategory })

                        )
                    }
                    Spacer(modifier = Modifier.height(8.dp))

                    // Category Dropdown menu implementation
                    if (expandedCategory) {
                        DropdownMenu(
                            expanded = expandedCategory,
                            onDismissRequest = { expandedCategory = false },
                            modifier = Modifier.fillMaxWidth()

                        ) {
                            // Displaying categories
                            categories.forEach { category ->
                                DropdownMenuItem(
                                    onClick = {
                                        selectedCategory = category
                                        expandedCategory = false
                                    },
                                    text = category
                   )
                            }
                        }
                    }
                }
            }

            // Add "Select Product" dropdown menu
            item {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 16.dp)
                        .padding(horizontal = 16.dp)
                ) {
                    var expandedProduct by remember { mutableStateOf(false) }
                    var selectedProduct by remember { mutableStateOf("Select Product") }
                    val products = listOf("Maize", "Beans", "Eggs", "Milk", "Honey")

                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Text(selectedProduct, Modifier.weight(1f))
                        Icon(
                            imageVector = Icons.Default.ArrowDropDown,
                            contentDescription = "Dropdown Icon",
                            modifier = Modifier.clickable(onClick = { expandedProduct = !expandedProduct })
                        )
                    }
                    Spacer(modifier = Modifier.height(8.dp))

                    // Product Dropdown menu implementation
                    if (expandedProduct) {
                        DropdownMenu(
                            expanded = expandedProduct,
                            onDismissRequest = { expandedProduct = false },
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            // Displaying products
                            products.forEach { product ->
                                DropdownMenuItem(
                                    onClick = {
                                        selectedProduct = product
                                        expandedProduct = false
                                    },
                                    text = product)
                            }
                        }
                    }
                }
            }

            // Add "Select Unit of Measurement" dropdown menu
            item {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 16.dp)
                        .padding(horizontal = 16.dp)
                ) {
                    var expandedUnit by remember { mutableStateOf(false) }
                    var selectedUnit by remember { mutableStateOf("Select Unit of Measurement") }
                    val units = listOf("Kgs", "Litres", "Trays", "Heads")

                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Text(selectedUnit, Modifier.weight(1f))
                        Icon(
                            imageVector = Icons.Default.ArrowDropDown,
                            contentDescription = "Dropdown Icon",
                            modifier = Modifier.clickable(onClick = { expandedUnit = !expandedUnit })
                 )
                    }
                    Spacer(modifier = Modifier.height(8.dp))

                    // Unit of Measurement Dropdown menu implementation
                    if (expandedUnit) {
                        DropdownMenu(
                            expanded = expandedUnit,
                            onDismissRequest = { expandedUnit = false },
                            modifier = Modifier.fillMaxWidth()
                     ) {
                            // Displaying units of measurement
                            units.forEach { unit ->
                                DropdownMenuItem(
                                    onClick = {
                                        selectedUnit = unit
                                        expandedUnit = false
                                    },
                                    text = unit
                        )
                            }
                        }
                    }
                }
            }

            // Add "Available Dates" text and text input
            item {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 16.dp)
                        .padding(horizontal = 16.dp)
          ) {
                    Text("Available Dates")
                    Spacer(modifier = Modifier.height(8.dp))
                    // Text input for dates (placeholder)
                    TextField(
                        value = "",
                        onValueChange = { },
                        label = { Text("Enter Date") },
                        modifier = Modifier.fillMaxWidth()
                    )
                }
            }

            // Add "Describe Location" text and text input
            item {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 16.dp)
                        .padding(horizontal = 16.dp)
         ) {
                    Text("Describe Location")
                    Spacer(modifier = Modifier.height(8.dp))
                    // Text input for location description (placeholder)
                    TextField(
                        value = "",
                        onValueChange = { },
                        label = { Text("Enter Location Description") },
                        modifier = Modifier.fillMaxWidth()
           )
                }
            }

            // Add "Description" text and text input
            item {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 16.dp)
                        .padding(horizontal = 16.dp)
            ) {
                    Text("Description")
                    Spacer(modifier = Modifier.height(8.dp))
                    // Text input for description (placeholder)
                    TextField(
                        value = "",
                        onValueChange = { },
                        label = { Text("Enter Description") },
                        modifier = Modifier.fillMaxWidth()
              )
                }
            }

            // Add "Price per Unit" text and text input
            item {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 16.dp)
                        .padding(horizontal = 16.dp)
           ) {
                    Text("Price per Unit")
                    Spacer(modifier = Modifier.height(8.dp))
                    // Text input for price per unit (placeholder)
                    TextField(
                        value = "",
                        onValueChange = { },
                        label = { Text("Enter Price per Unit") },
                        modifier = Modifier.fillMaxWidth()
                    )
                }
            }

            // Add "Next" button
            item {
                Button(
                    onClick = { /* Handle next button click */ },
                    modifier = Modifier
                        .padding(vertical = 16.dp)
                        .fillMaxWidth()

                ) {
                    Text(text = "Next")
                }
            }

            // Add tasks below the dropdown menus
            item {
                Spacer(modifier = Modifier.height(16.dp))
                TaskItem(text = "Fruits")
                TaskItem(text = "Cereals")
                TaskItem(text = "Poultry")
                TaskItem(text = "Vegetables")
                TaskItem(text = "Legumes")
                TaskItem(text = "Dairy")
            }
        }
    }

