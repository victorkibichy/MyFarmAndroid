@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.jpapp.UX

//noinspection UsingMaterialAndMaterial3Libraries




import  android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.Text
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.jpapp.R
import com.example.jpapp.R.VerificationPage
import com.example.jpapp.network.RetrofitClient


class  MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            val apiService = RetrofitClient.instance

            NavHost(navController, startDestination = "SplashScreen") {
                composable("SplashScreen") {
                    SplashScreen(navController)
                }

                composable("sign in") {
                    LoginPage(navController = navController, apiService = apiService)
                }
                composable("registration") {
                    RegistrationPage(onBackPressed = { navController.popBackStack() })
                }
                composable("dashboard") {
                    DashboardPage(navController)
                }
                composable("myFarm") {
                    MyFarmScreen(navController)
                }
                composable("survey123_login") {
                    MyFarmScreen(navController)
                }
                composable("my_market") {
                    MyMarketPage(navController = navController)
                }
                composable("newFarmProduce") {
                    NewFarmProduceScreen(navController = navController)
                }
                composable("forgot_password") {
                    ForgotPasswordScreen(navController)
                }
                composable("farmTechPage") {
                    FarmTechPage(navController)
                }
                composable("create_password") {
                    CreatePasswordScreen(navController)
                }
                composable("login_page") {
                    LoginForgotPasswordPage(navController)
                }
                composable("drawerMenu") {
                    DrawerMenuScreen(navController)
                }
                composable("support") {
                    SupportScreen(navController)
                }
                composable("ServicesPage") {
                    ServicesPage(navController)

                }
                composable("FarmInputsPage") {
                    FarmInputsPage(navController)
                }
                composable("MarketPlace") {
                    Marketplace(navController)
                }

                composable("VerificationPage") {
                    VerificationPage()
                }
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

    @Composable
    fun DrawerMenuScreen(navController: NavController) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
                .padding(50.dp)

        ) {
            // Title with profile icon
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.clickable {
                    // Handle profile click action (you can customize this action)
                    // Example: navController.navigate("update_profile")
                    navController.navigate("update_profile")
                }
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.profile_icon),
                    contentDescription = "Update Profile",
                    modifier = Modifier
                        .size(50.dp)
                )
                Text("my profile")
            }

            // Menu items
            Spacer(modifier = Modifier.height(32.dp))
            DrawerMenuItem(text = "Home") {
                navController.navigate("dashboard")
            }
            Spacer(modifier = Modifier.height(16.dp))
            DrawerMenuItem(text = "My Account") {
                navController.navigate("my_account")
            }
            Spacer(modifier = Modifier.height(16.dp))
            DrawerMenuItem(text = "Settings") {
                navController.navigate("settings")
            }
            Spacer(modifier = Modifier.height(16.dp))
            DrawerMenuItem(text = "Logout") {
                navController.navigate("login")
            }
        }
    }

    @Composable
    fun DrawerMenuItem(text: String, onClick: () -> Unit) {
        Text(
            text = text,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.clickable(onClick = onClick)
        )
    }
