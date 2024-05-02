package com.example.jpapp.UX

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.jpapp.R

sealed class Tab {
        data class Machineries(val navController: NavController) : Tab()
        data class Tools(val navController: NavController) : Tab()
    }

    @Composable
    fun FarmTechPage(navController: NavController) {
        var selectedTab by remember { mutableStateOf<Tab>(Tab.Machineries(navController)) }
        val navController = rememberNavController()

        MaterialTheme(
            colors = lightColors(primary = colorResource(id = R.color.maroon))
        ){
            Scaffold(
                topBar = {
                    TopAppBar(
                        title = { Text("Farm Tech") },
                        navigationIcon = {
                            IconButton(onClick = { navController.navigateUp() }) {
                                Icon(
                                    painter = painterResource(id = R.drawable.ic_arrow_back_foreground),
                                    contentDescription = "Back to Dashboard"
                                )
                            }
                        },
                        backgroundColor = MaterialTheme.colors.primary,
                        contentColor = MaterialTheme.colors.onPrimary,
                        elevation = 4.dp
                    )
                },
                content = { paddingValues ->
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(paddingValues)
                            .padding(16.dp)
                    ) {
                        TabRow(
                            selectedTabIndex = if (selectedTab is Tab.Machineries) 0 else 1,
                            modifier = Modifier.padding(bottom = 16.dp)
                        ) {
                            Tab(
                                selected = selectedTab is Tab.Machineries,
                                onClick = { selectedTab = Tab.Machineries(navController) }
                            ) {
                                Text(text = "Machineries")
                            }
                            Tab(
                                selected = selectedTab is Tab.Tools,
                                onClick = { selectedTab = Tab.Tools(navController) }
                            ) {
                                Text(text = "Tools")
                            }
                        }

                        Spacer(modifier = Modifier.height(16.dp))

                        when (selectedTab) {
                            is Tab.Machineries -> (selectedTab as Tab.Machineries).navController.MachineriesTabContent()
                            is Tab.Tools -> (selectedTab as Tab.Tools).navController.ToolsTabContent()
                        }
                    }
                }
            )
        }
    }


