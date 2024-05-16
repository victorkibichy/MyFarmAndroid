package com.example.jpapp.UX

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.jpapp.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DashboardPage(navController: NavController) {
    Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Add a top app bar with red background color and margin
        TopAppBar(
                title = {
                    Text(text = "Equifarm")
                },
                navigationIcon = {
                    // Add an icon button for the drawer menu
                    IconButton(onClick = {
                        // Handle opening the drawer menu (you can customize this action)
                        // Example: navController.openDrawer()
                        navController.navigate("drawerMenu")
                    }) {
                        Icon(
                                imageVector = Icons.Default.Menu, // Menu icon
                                contentDescription = "Menu"
                        )
                    }
                },
                actions = {
                    // Add an icon button for notifications
                    IconButton(onClick = {
                        // Handle the notification button click (you can customize this action)
                        // Example: navController.navigate("notifications")
                        navController.navigate("notifications")
                    }) {
                        Icon(
                                imageVector = Icons.Default.Notifications, // Notifications icon
                                contentDescription = "Notifications"
                        )
                    }
                },
                modifier = Modifier.padding(top = 10.dp),
                colors = TopAppBarDefaults.run {
                    return@run topAppBarColors(
                            Color.Red, Color.White // Red background color
                            // Text color
                    )
                }
        )


        // Add the Grid of Cards
        GridOfCards(navController)
        Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Bottom,
                horizontalAlignment = Alignment.CenterHorizontally
        )
        {
            BottomAppBar(contentColor = Color.Black,)
            {
                Row(
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.fillMaxWidth()
                )
                {
                    // Put your content here, like buttons or icons
                    IconButton(onClick = {}) {
                        Icon(imageVector = Icons.Default.Home, contentDescription = "Home")
                    }
                    IconButton(onClick = {}) {
                        Icon(imageVector = Icons.Default.Favorite, contentDescription = "Favorite")
                    }

                    IconButton(onClick = {}) {
                        Icon(
                                imageVector = Icons.Default.ShoppingCart,
                                contentDescription = "ShoppingCart"
                        )
                    }

                    IconButton(onClick = {}) {
                        Icon(imageVector = Icons.Default.Person, contentDescription = "Profile")
                    }
                    IconButton(onClick = { navController.navigate("MarketPlace") }) {
                        Icon(imageVector = Icons.Default.List, contentDescription = "Marketplace")
                    }

                }
            }


        }
    }
}

@Composable
fun GridOfCards(navController: NavController) {
    val cardTitles = listOf(
            "My Farm", "Farm Tech", "Training",
            "Farm Inputs", "Services", "Transport",
            "Produce", "Insurance", "Support"
    )
    val cardImages = listOf(
            R.drawable.myfarm, R.drawable.farm_tech, R.drawable.training,
            R.drawable.farm_inputs, R.drawable.services, R.drawable.transport,
            R.drawable.produce, R.drawable.insurance, R.drawable.support
    )

    Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
    ) {
        repeat(3) { rowIndex ->
            Row(
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    modifier = Modifier.fillMaxWidth()
            ) {
                repeat(3) { columnIndex ->
                    val cardIndex = rowIndex * 3 + columnIndex
                    DashboardCard(
                            title = cardTitles[cardIndex],
                            imageResource = cardImages[cardIndex],
                            navController = navController,
                    )
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DashboardCard(title: String, navController: NavController, imageResource: Int) {
    Card(
            modifier = Modifier
                .padding(8.dp)
                .width(90.dp)
                .height(90.dp),
            onClick = {
                when (title) {
                    "My Farm" -> navController.navigate("survey123_login")
                    "Produce" -> navController.navigate("my_market")
                    "Farm Tech" -> navController.navigate("FarmTechPage")
                    "Support" -> navController.navigate("support")
                    "Services" -> navController.navigate("ServicesPage")
                    "Farm Inputs" -> navController.navigate("FarmInputsPage")
                    "List Icon" -> navController.navigate("MarketPlace")
                }
            }
    ) {
        Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Bottom,
                horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                    text = title,
                    style = MaterialTheme.typography.bodyMedium,
                    color = Color.Black // Set text color to black
            )
            Spacer(modifier = Modifier.height(8.dp))
            Image(
                    painter = painterResource(id = imageResource),
                    contentDescription = null,
                    modifier = Modifier
                        .width(120.dp)
                        .height(120.dp)
            )
        }
    }
}