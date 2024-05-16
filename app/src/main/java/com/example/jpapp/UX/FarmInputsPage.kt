package com.example.jpapp.UX

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.jpapp.R

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun FarmInputsPage(navController: NavController) {
    Scaffold(
        topBar = {
            EquiFarmTopAppBar()
        }
    ) {
        LazyColumn(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxSize()
        ) {
            item {
                Text(
                    text = "",
                    style = MaterialTheme.typography.h5,
                    modifier = Modifier.padding(bottom = 16.dp)
                )
            }
            val cardTitles = List(14) { index -> "Card ${index + 1}" }
            val cardDescriptions = List(14) { index -> "Insecticide Wabora Agrovet${index + 1}" }
            val imageResIds = List(14) { index -> getImageResourceId(index) }
            val chunkedCardTitles = cardTitles.chunked(2)
            val chunkedCardDescriptions = cardDescriptions.chunked(2)
            val chunkedImageResIds = imageResIds.chunked(2)
            items(chunkedCardTitles) { rowCardTitles ->
                Row(Modifier.fillMaxWidth()) {
                    rowCardTitles.forEachIndexed { index, cardTitle ->
                        FarmInputCard(
                            name = cardTitle,
                            description = chunkedCardDescriptions[chunkedCardTitles.indexOf(rowCardTitles)][index],
                            imageResId = chunkedImageResIds[chunkedCardTitles.indexOf(rowCardTitles)][index]
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun EquiFarmTopAppBar() {
    TopAppBar(
        title = {
            Text(
                text = "EquiFarm",
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentWidth(Alignment.CenterHorizontally)
            )
        },
        backgroundColor = Color.Red, // Set the background color of the top app bar to red
        actions = {
            IconButton(onClick = { /* Handle notification icon click */ }) {
                Icon(
                    imageVector = Icons.Default.Notifications,
                    contentDescription = "Notification Icon"
                )
            }
        },
        navigationIcon = {
            IconButton(onClick = { /* Handle dropdown menu click */ }) {
                Icon(
                    imageVector = Icons.Default.ArrowDropDown,
                    contentDescription = "Dropdown Menu"
                )
            }
        },
        modifier = Modifier.padding(start = 8.dp, end = 8.dp)
    )
}

@Composable
fun FarmInputCard(name: String, description: String, imageResId: Int) {
    Card(
        modifier = Modifier
            .padding(8.dp)
            .width(150.dp)
            .height(200.dp)
    ) {
        Column(modifier = Modifier.fillMaxSize()) {
            Image(
                painter = painterResource(id = imageResId),
                contentDescription = "Farm Input Image",
                modifier = Modifier
                    .fillMaxSize()
                    .weight(1f)
            )
            Text(
                text = name,
                modifier = Modifier.padding(16.dp)
            )
            Text(
                text = description,
                style = MaterialTheme.typography.body2,
                modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)
            )
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(color = Color.Red)
                    .padding(vertical = 8.dp),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "Add to Cart",
                    style = MaterialTheme.typography.body2.copy(fontWeight = FontWeight.Bold, color = Color.White)
                )
            }
        }
    }
}

private fun getImageResourceId(index: Int): Int {
    return when (index) {
        1 -> R.drawable.dawa
        2 -> R.drawable.fertilizer
        3 -> R.drawable.manure
        4 -> R.drawable.insecticide
        5 -> R.drawable.lime
        6 -> R.drawable.dawa
        7 -> R.drawable.dawa
        8 -> R.drawable.insecticide
        9 -> R.drawable.lime
        10 -> R.drawable.dawa
        11 -> R.drawable.manure
        12 -> R.drawable.fertilizer
        13 -> R.drawable.insecticide
        14 -> R.drawable.dawa
        else -> R.drawable.fertilizer
    }
}
