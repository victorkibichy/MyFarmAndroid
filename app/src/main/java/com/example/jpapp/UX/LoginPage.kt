package com.example.jpapp.UX

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.jpapp.ApiService
import com.example.jpapp.R
import com.example.jpapp.data.AuthUserRequest
import com.example.jpapp.data.AuthUserResponse
import com.example.jpapp.network.EntityResponse
import com.google.firebase.database.FirebaseDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

@Composable
fun LoginPage(navController: NavController, apiService: ApiService,
              isResettingPassword: Boolean = false) {
    val maroon = Color(0xFF800000)

    var emailOrNationalId by remember { mutableStateOf(TextFieldValue()) }
    var password by remember { mutableStateOf(TextFieldValue()) }
    var showDialog by remember { mutableStateOf(false) }
    var isLoading by remember { mutableStateOf(false) }
    var errorMessage by remember { mutableStateOf<String?>(null) }
    var loginMessage by remember { mutableStateOf<String?>(null) }
    var passwordVisibility by remember { mutableStateOf(false) }

    fun performSignin() {
        if (emailOrNationalId.text.isEmpty() || password.text.isEmpty()) {
            // Show error dialog
            showDialog = true
            errorMessage = "Email and Password are required."
            return
        }

        isLoading = true
        val loginRequest = AuthUserRequest(
            emailOrNationalId = emailOrNationalId.text,
            password = password.text
        )

        apiService.signin(loginRequest).enqueue(object : Callback<EntityResponse<AuthUserResponse>> {
            override fun onResponse(
                call: Call<EntityResponse<AuthUserResponse>>,
                response: Response<EntityResponse<AuthUserResponse>>
            ) {
                isLoading = false
                if (response.isSuccessful) {
                    val entityResponse = response.body()
                    if (entityResponse != null && entityResponse.message == "Authentication successful") {
                        loginMessage = "Login successful"
                        CoroutineScope(Dispatchers.Main).launch {
                            delay(2000) // 3 seconds delay
                            navController.navigate("dashboard")
                        }
                    } else {
                        errorMessage = "Invalid Email or Password"
                    }
                } else {
                    errorMessage = "Unsuccessful login response: ${response.code()}"
                }
            }



            override fun onFailure(p0: Call<EntityResponse<AuthUserResponse>>, p1: Throwable) {
                isLoading = false
                errorMessage = "Network failure: ${p1.message}"            }
        })
    }

    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.equitylogo),
            contentDescription = null,
            modifier = Modifier.padding(vertical = 18.dp)
        )

        Spacer(modifier = Modifier.height(3.dp))
        Box(
            modifier = Modifier
                .width(150.dp)
                .height(40.dp)
                .background(color = Color(0xFFFF5722))
        ) {
            Text(
                text = "EQUIFARM",
                fontSize = 20.sp,
                style = MaterialTheme.typography.displayMedium,
                modifier = Modifier.align(Alignment.Center)
            )
        }
        Spacer(modifier = Modifier.height(35.dp))
        Text(
            text = "Welcome",
            fontSize = 24.sp,
            color = Color.Black,
            modifier = Modifier.align(Alignment.Start)
        )

        Spacer(modifier = Modifier.height(5.dp))
        // Add "Sign in to continue" text below the box
        Text(
            text = "Sign in to continue,",
            fontSize = 18.sp,
            color = Color.Gray,
            modifier = Modifier.align(Alignment.Start)
        )

        Spacer(modifier = Modifier.height(35.dp))
        // Add Email or National ID field
        TextField(
            value = emailOrNationalId,
            onValueChange = { emailOrNationalId = it },
            label = { Text("Email or National ID ") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(10.dp))
        errorMessage?.let {
               Text(
                text = it,
                colorhh  = Color.Red,
                modifier = Modifier.padding(vertical = 5.dp)
            )
        }
        Spacer(modifier = Modifier.height(25.dp))
        // Add Password field
        TextField(
            value = password,
            onValueChange = { password = it },
            label = { Text("Enter your Password ") },
            visualTransformation = PasswordVisualTransformation(),
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(10.dp))

        // Sign in button
        Box(
            modifier = Modifier
                .width(350.dp)
                .height(50.dp)
                .background(color = Color.LightGray)
                .clickable { performSignin() }
        ) {
            Text(
                text = "Sign in",
                color = maroon,
                fontSize = 20.sp,
                style = MaterialTheme.typography.displayMedium,
                modifier = Modifier.align(Alignment.Center)
            )
        }

        Spacer(modifier = Modifier.height(10.dp))
        loginMessage?.let {
            Text(
                text = it,
                color = Color.Green,
                modifier = Modifier.padding(vertical = 5.dp)
            )
        }
        Spacer(modifier = Modifier.height(10.dp))
        Text(
            "Forgot Password?",
            color = MaterialTheme.colorScheme.primary,
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.End)
                .clickable {
                    navController.navigate("forgot_password")
                }
        )
        Spacer(modifier = Modifier.height(20.dp))
        Text(
            text = buildAnnotatedString {
                append("Don't have an account? ")
                withStyle(
                    style = SpanStyle(
                        color = maroon, // Set the color to maroon
                        fontWeight = FontWeight.Bold
                    )
                ) {
                    append("Sign up")
                }
            },
            modifier = Modifier.clickable {
                // Handle click for the "Sign up" portion
                createNode()
                navController.navigate("registration")
            }
        )

        Spacer(modifier = Modifier.height(20.dp))
        Text(
            text = buildAnnotatedString {
                append("Switch account?")
                withStyle(
                    style = SpanStyle(
                        color = maroon, // Set the color to maroon
                        fontWeight = FontWeight.Bold
                    )
                ) {
                    append("Yes")
                }
            },
        )

        // Spinner when waiting for response
        if (isLoading) {
            CircularProgressIndicator()
        }


    }
}

fun createNode(){

    val db = FirebaseDatabase.getInstance().reference
    db.child("users").push().setValue("Gilbert korir")
}