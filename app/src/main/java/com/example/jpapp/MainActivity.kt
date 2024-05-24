@file:OptIn(ExperimentalMaterial3Api::class, ExperimentalMaterial3Api::class)

package com.example.jpapp

<<<<<<< HEAD
//noinspection UsingMaterialAndMaterial3Libraries
import FarmInputsPage
import ServicesPage
import android.os.Bundle
=======
import android.annotation.SuppressLint
import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
>>>>>>> a8f727c8b42264c2f89a3c61b867dcfe01279c5e
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import java.time.LocalDate

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
                composable("forgot_password") {
                    ForgotPasswordPage(navController)
                }
                composable("farmTech"){
                    FarmTechPage(navController)
                }

<<<<<<< HEAD
                }
                composable("FarmInputsPage"){
                    FarmInputsPage(navController)
                }
                composable("MarketPlace"){
                    Marketplace(navController)
                }
=======
>>>>>>> a8f727c8b42264c2f89a3c61b867dcfe01279c5e
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
        Text(
            "Forgot Password?",
            color = MaterialTheme.colorScheme.primary,
            modifier = Modifier.clickable {
                navController.navigate("forgot_password")
            }
        )
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
                            label = { Text("Second Name") },
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
                        label = { Text("National ID") },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 16.dp),
                        colors = TextFieldDefaults.textFieldColors(MaterialTheme.colorScheme.background)
                )
                Spacer(modifier = Modifier.height(16.dp))
                TextField(
                        value = "",
                        onValueChange = { },
                        label = { Text("Email") },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 16.dp),
                        colors = TextFieldDefaults.textFieldColors(MaterialTheme.colorScheme.background)
                )
                Spacer(modifier = Modifier.height(16.dp))
                TextField(
                        value = "",
                        onValueChange = { },
                        label = { Text("Phone No") },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 16.dp),
                        colors = TextFieldDefaults.textFieldColors(MaterialTheme.colorScheme.background)
                )
                Spacer(modifier = Modifier.height(16.dp))
                MainRoleSpinner()
                Spacer(modifier = Modifier.height(16.dp))
                TextField(
                        value = "",
                        onValueChange = { },
                        label = { Text("Password") },
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
                        label = { Text("Confirm Password") },
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
                            text = "I agree to the Terms and Policy",
                            modifier = Modifier.padding(start = 8.dp)
                    )
                }
                Spacer(modifier = Modifier.height(16.dp))
                SignupButton(onSignupClick = onBackPressed, text = "Sign Up")

            }
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
fun ForgotPasswordPage(navController: NavController) {
    // State for the email input
    var email by remember { mutableStateOf("") }
    // State for showing feedback to the user (success or error message)
    var feedbackMessage by remember { mutableStateOf<String?>(null) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Title
        Text(
            text = "Forgot Password",
            style = MaterialTheme.typography.bodyMedium,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        // Email input field
        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            label = { Text("Email Address") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Button to send password reset link
        Button(
            onClick = {
                // Handle password reset logic here
                if (email.isNotEmpty()) {
                    // Simulate password reset request
                    // You may replace this with actual password reset logic
                    feedbackMessage = "Password reset link sent to your email address!"
                } else {
                    feedbackMessage = "Please enter a valid email address."
                }
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Send Password Reset Link")
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Display feedback message to the user (success or error)
        feedbackMessage?.let { message ->
            Text(
                text = message,
                color = if (message.contains("sent")) Color.Green else Color.Red,
                modifier = Modifier.padding(top = 8.dp)
            )
        }

        // Back to login button
        Button(
            onClick = {
                navController.navigate("login") {
                    popUpTo("forgot_password") { inclusive = true }
                }
            },
            modifier = Modifier
                .padding(top = 16.dp)
                .fillMaxWidth()
        ) {
            Text("Back to Login")
        }
    }
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
                    "Farm Tech" -> navController.navigate("FarmTechPage")
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
fun FarmTechPage(navController: NavHostController) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Farm Tech") },
                modifier = Modifier.padding(bottom = 8.dp)
            )
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = { /* Add new farming technology action */ },
                content = { Icon(Icons.Default.Add, contentDescription = "Add") }
            )
        }
    ) { paddingValues ->
        LazyColumn(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize(),
            contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp)
        ) {
            item {
                FarmingTechCard(
                    imagePainter = painterResource(id = R.drawable.tractor),
                    title = "Smart Tractor",
                    description = "A smart tractor with GPS and autonomous driving capabilities for efficient farming."
                )
            }
            item {
                FarmingTechCard(
                    imagePainter = painterResource(id = R.drawable.irrigation),
                    title = "Advanced Irrigation System",
                    description = "An advanced irrigation system that uses sensors to optimize water usage."
                )
            }
            // Add more FarmingTechCard instances as needed
        }
    }
}

@Composable
fun FarmingTechCard(
    imagePainter: Painter,
    title: String,
    description: String
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 8.dp)
            .clip(MaterialTheme.shapes.medium),
        elevation = CardDefaults.elevation(4.dp)
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Image(
                painter = imagePainter,
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(180.dp)
                    .clip(MaterialTheme.shapes.medium)
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = title,
                style = MaterialTheme.typography.titleMedium.copy(fontSize = 18.sp),
                modifier = Modifier.padding(bottom = 4.dp)
            )
            Text(
                text = description,
                style = MaterialTheme.typography.bodyMedium.copy(textAlign = TextAlign.Justify)
            )
        }
    }
}

private fun CardDefaults.elevation(dp: Dp): CardElevation {
    TODO("Not yet implemented")
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