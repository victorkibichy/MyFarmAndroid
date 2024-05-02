package com.example.jpapp.UX
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
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
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.jpapp.ApiService
import com.example.jpapp.R
import com.example.jpapp.data.AuthUser
import com.example.jpapp.network.EntityResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

@Composable
fun LoginPage(navController: NavController, apiService: ApiService, isResettingPassword: Boolean = false) {
    val maroon = Color(0xFF800000)

    var emailOrNationalId by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var showDialog by remember { mutableStateOf(false) }

    fun performSignin(navController: NavController, apiService: ApiService) {
        val loginRequest = AuthUser(emailOrNationalId = emailOrNationalId, password = password)
        apiService.signin(loginRequest).enqueue(object : Callback<EntityResponse<AuthUser>> {
            override fun onResponse(
                call: Call<EntityResponse<AuthUser>>,
                response: Response<EntityResponse<AuthUser>>
            ) {
                if (response.body()?.message == "Authentication successful") {
                    val entityResponse = response.body()
                    if (entityResponse != null) {
                        // Handle successful login response
                        val data = entityResponse.entity
                        if (data != null) {
                            // Successfully logged in, navigate to dashboard
                            navController.navigate("dashboard")
                        } else {
                            // Response entity is null
                            Log.d("Signin", "Null response entity")
                        }
                    } else {
                        // Handle null response body
                        Log.d("Signin", "Null response body")
                    }
                } else if(response.body()?.message == "Invalid Email or Password") {


                    // Handle unsuccessful login response
                    Log.d("Signin", "Invalid password or user data: ${response.code()}")
                }else {

                    Log.d("Signin", "Unsuccessful login response: ${response.code()}")


                }
            }

            override fun onFailure(call: Call<EntityResponse<AuthUser>>, t: Throwable) {
                // Handle network failure
                Log.e("Signin", "Network failure: ${t.message}", t)
            }
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
                onValueChange = { newTextValue -> emailOrNationalId = newTextValue },
                label = { Text("Email or National ID ") },
                modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(35.dp))
        // Add Password field
        TextField(
                value = password,
                onValueChange = { newTextValue -> password = newTextValue },
                label = { Text("Enter your Password ") },
                modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(35.dp))

        // Sign in button
        Box(
                modifier = Modifier
                    .width(350.dp)
                    .height(50.dp)
                    .background(color = Color.LightGray)
                    .clickable { performSignin(navController, apiService) }
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

        // Dialog for showing error
        if (showDialog) {
            AlertDialog(
                    onDismissRequest = { showDialog = false },
                    title = { Text("Error") },
                    text = { Text("Email and Password are required.") },
                    confirmButton = {
                        Button(onClick = { showDialog = false }) {
                            Text("OK")
                        }
                    }
            )
        }
    }
}

