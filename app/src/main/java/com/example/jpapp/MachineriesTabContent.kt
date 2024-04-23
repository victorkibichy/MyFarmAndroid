package com.example.jpapp

import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

    @Composable
    fun NavController.MachineriesTabContent() {
        val machineryImages = listOf(
            R.drawable.farm_image_1,
            R.drawable.farm_image_1,
            R.drawable.farm_image_1,
            R.drawable.farm_image_1,
            R.drawable.farm_image_1,
            R.drawable.farm_image_1,

            )
        val cartItems = remember { mutableStateListOf<Int>() }

        LazyVerticalGrid(
            columns = GridCells.Adaptive(minSize = 128.dp)
        ) {
            items(machineryImages) { machineryImage ->
                MachineryCard(
                    imageResource = R.drawable.farm_image_1,
                    machineName = "Tractor",
                    sellerName = "four farmers ltd",
                    price = "sh 1000",
                    availability = "In Stock"
                )
            }
        }
    }

