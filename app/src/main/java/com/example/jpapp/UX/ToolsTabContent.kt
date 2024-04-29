package com.example.jpapp.UX
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.jpapp.R


@Composable
    fun NavController.ToolsTabContent() {
        val toolImages = listOf(
                R.drawable.farm_image_2,
                R.drawable.farm_image_2,
                R.drawable.farm_image_2,
                R.drawable.farm_image_2,
                R.drawable.farm_image_2,
                R.drawable.farm_image_2,

            // Add more tool images here
        )
        val favoriteItems = remember { mutableStateListOf<Int>() }

        LazyVerticalGrid(
            columns = GridCells.Adaptive(minSize = 128.dp)
        ) {
            items(toolImages) { toolImage ->
                ToolCard(
                    imageResource = R.drawable.farm_image_2,
                    toolName = "wheelbarrow",
                    sellerName = "four farmers ltd",
                    price = "sh 1000",
                    availability = "In Stock")
            }
        }
    }

