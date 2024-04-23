@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.jpapp


import android.annotation.SuppressLint
import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.Checkbox
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import java.time.LocalDate
import androidx.compose.ui.Alignment

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            NavHost(navController, startDestination = "login") {
                composable("login") {
                    LoginPage(navController = navController)
                }
                composable("registration") {
                    RegistrationPage(onBackPressed = { navController.popBackStack() })
                }
                composable("dashboard") {
                    DashboardPage(navController)
                }
                composable("myFarm") {
                    MyFarmScreen()
                }
                composable("survey123_login") {
                    MyFarmScreen()
                }
                composable("my_market") {

                    MyMarketPage(navController = navController)
                }
                composable("newFarmProduce") {
                    NewFarmProduceScreen(navController = navController)
                }
                composable("support") {
                    SupportScreen(navController)
                }

            }
        }
    }
}

@Composable
fun LoginPage(navController: NavController) {
    Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
    ) {
        Image(
                painter = painterResource(id = R.drawable.equitylogo),
                contentDescription = null,
                modifier = Modifier.padding(vertical = 16.dp)
        )
        UsernameField()
        Spacer(modifier = Modifier.height(16.dp))
        PasswordField()
        Spacer(modifier = Modifier.height(16.dp))
        // Login button with navigation
        LoginButton(onClick = {
            navController.navigate("dashboard")
        })
        Spacer(modifier = Modifier.height(8.dp))
        SignupButton(onSignupClick = { navController.navigate("registration") })
    }
}

@Composable
fun RegistrationPage(onBackPressed: () -> Unit) {
    var termsChecked by remember { mutableStateOf(false) } // State for checkbox

    LazyColumn(
            modifier = Modifier.fillMaxSize()
    ) {
        item {
            Column(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
            ) {
                Image(
                        painter = painterResource(id = R.drawable.equitylogo),
                        contentDescription = null,
                        modifier = Modifier.padding(vertical = 16.dp)
                )
                Text(
                        text = "Equifarm",
                        color = Color.Red,
                        fontSize = 30.sp
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                        text = "Create an account",
                        modifier = Modifier.padding(horizontal = 16.dp)
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = "Let's get you an account,",
                    modifier = Modifier.padding(horizontal = 16.dp)
                )
                Spacer(modifier = Modifier.height(16.dp))
                Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                ) {
                    TextField(
                            value = "",
                            onValueChange = { },
                            label = { Text("First Name") },
                            modifier = Modifier
                                .weight(1f)
                                .padding(start = 16.dp),
                            colors = TextFieldDefaults.textFieldColors(MaterialTheme.colorScheme.background)
                    )
                    Spacer(modifier = Modifier.width(16.dp)) // Line break
                    TextField(
                            value = "",
                            onValueChange = { },
                            label = { Text("Last Name") },
                            modifier = Modifier
                                .weight(1f)
                                .padding(end = 16.dp),
                            colors = TextFieldDefaults.textFieldColors(MaterialTheme.colorScheme.background)
                    )
                }
                Spacer(modifier = Modifier.height(16.dp))
                TextField(
                        value = "",
                        onValueChange = { },
                        label = { Text("National ID Number") },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 16.dp),
                        colors = TextFieldDefaults.textFieldColors(MaterialTheme.colorScheme.background)
                )
                Spacer(modifier = Modifier.height(16.dp))
                TextField(
                        value = "",
                        onValueChange = { },
                        label = { Text(" Your Email") },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 16.dp),
                        colors = TextFieldDefaults.textFieldColors(MaterialTheme.colorScheme.background)
                )
                Spacer(modifier = Modifier.height(16.dp))
                TextField(
                        value = "",
                        onValueChange = { },
                        label = { Text("Phone Number") },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 16.dp),
                        colors = TextFieldDefaults.textFieldColors(MaterialTheme.colorScheme.background)
                )
                Spacer(modifier = Modifier.height(16.dp))
                TextField(
                    value = "",
                    onValueChange = { },
                    label = { Text("Select Main Role") },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp),
                    colors = TextFieldDefaults.textFieldColors(MaterialTheme.colorScheme.background)
                )
                Spacer(modifier = Modifier.height(16.dp))
                TextField(
                        value = "",
                        onValueChange = { },
                        label = { Text("Enter your Password") },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 16.dp),
                        colors = TextFieldDefaults.textFieldColors(MaterialTheme.colorScheme.background),
                        visualTransformation = PasswordVisualTransformation(),
                        keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Next),
                        keyboardActions = KeyboardActions(onNext = { /* Handle next action here */ })
                )
                Spacer(modifier = Modifier.height(16.dp))
                TextField(
                        value = "",
                        onValueChange = { },
                        label = { Text("Confirm your Password") },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 16.dp),
                        colors = TextFieldDefaults.textFieldColors(MaterialTheme.colorScheme.background),
                        visualTransformation = PasswordVisualTransformation(),
                        keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Done),
                        keyboardActions = KeyboardActions(onDone = { /* Handle done action here */ })
                )
                Spacer(modifier = Modifier.height(16.dp))
                // Checkbox for terms and policy
                Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically
                ) {
                    Checkbox(
                            checked = termsChecked,
                            onCheckedChange = { isChecked -> termsChecked = isChecked },
                            modifier = Modifier.padding(start = 16.dp)
                    )
                    Text(
                            text = "By continuing, you automatically accept our terms & conditions privacy policy and cookies policy",

                        modifier = Modifier.padding(start = 8.dp)
                    )
                }
                Spacer(modifier = Modifier.height(16.dp))
                SignupButton(onSignupClick = onBackPressed, text = "Sign Up")

            }

                Spacer(modifier = Modifier.height(10.dp))

                Text(
                    text = buildAnnotatedString {
                        append("Already have an account? ")
                        withStyle(
                            style = SpanStyle(
                                fontWeight = FontWeight.Bold
                            )
                        ) {
                            append("Sign in")
                        }
                    },
                    modifier = Modifier.clickable { /* Handle click and navigate to the next screen */ }
                )
            }
        }
    }


@Composable
fun UsernameField() {
    TextField(
            value = "",
            onValueChange = { },
            label = { Text("Username") },
            modifier = Modifier.fillMaxWidth(),
            colors = TextFieldDefaults.textFieldColors(MaterialTheme.colorScheme.background)
    )
}

@Composable
fun PasswordField() {
    TextField(
            value = "",
            onValueChange = { },
            label = { Text("Password") },
            modifier = Modifier.fillMaxWidth(),
            keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Done),
            keyboardActions = KeyboardActions(onDone = { /* Handle action here */ }),
            colors = TextFieldDefaults.colors()
    )
}

@Composable
fun LoginButton(onClick: () -> Unit) {
    TextButton(
            onClick = onClick,
            modifier = Modifier.fillMaxWidth()
    ) {
        Text("Login")
    }
}

@Composable
fun SignupButton(onSignupClick: () -> Unit, text: String = "Do you have an account? Sign Up") {
    TextButton(
            onClick = onSignupClick,
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp),
            colors = ButtonDefaults.textButtonColors(contentColor = Color.Red)
    ) {
        Text(text, color = Color.Red)
    }
}

@SuppressLint("AutoboxingStateCreation")
@Composable
fun MainRoleSpinner() {
    val roles = listOf("Farmer", "Agro Dealer", "Transporter", "Buyer", "Service Provider")
    var selectedRoleIndex by remember { return@remember mutableStateOf(0) }

    Column(modifier = Modifier.padding(horizontal = 16.dp)) {
        Text(text = "Select Main Role")
        Spacer(modifier = Modifier.height(8.dp))
        androidx.compose.material3.TextField(
                value = roles[selectedRoleIndex],
                onValueChange = { /* Handle value change */ },
                readOnly = true,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp)
        )
        androidx.compose.material3.DropdownMenu(
                expanded = false,
                onDismissRequest = { },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp)
        ) {
            roles.forEachIndexed { index, role ->

            }
        }
    }
}
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
                    "Support" -> navController.navigate("support")

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
                    style = MaterialTheme.typography.bodyMedium
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
@Composable
fun MyFarmScreen() {
    val url = "https://www.arcgis.com/sharing/rest/oauth2/authorize?client_id=survey123hub&display=default&redirect_uri=https%3A%2F%2Fsurvey123.arcgis.com%2Fsurveys&parent=https://survey123.arcgis.com&locale=en&response_type=token&expiration=720"

    AndroidView(
            modifier = Modifier.fillMaxSize(),
            factory = { context ->
                WebView(context).apply {
                    settings.javaScriptEnabled = true
                    webViewClient = WebViewClient()
                    loadUrl(url)
                }
            }
    )
}
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
                                    text = product
                            )
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

@Composable
fun DropdownMenuItem(
    onClick: () -> Unit,
    text: String,
    modifier: Modifier = Modifier
) {
    Text(
            text = text,
            modifier = modifier
                .fillMaxWidth()
                .clickable(onClick = onClick)
                .padding(vertical = 8.dp, horizontal = 16.dp)
    )
}

@Composable
fun TaskItem(text: String) {
    // Placeholder for TaskItem
}
