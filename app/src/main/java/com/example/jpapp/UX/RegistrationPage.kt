package com.example.jpapp.UX
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
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
import com.example.jpapp.network.EntityResponse
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.Icon
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.toUpperCase
import com.example.jpapp.data.RegistrationRequest
import com.example.jpapp.data.RegistrationResponse
import com.example.jpapp.data.Role
import com.example.jpapp.data.CountryCode
import com.example.jpapp.data.countryCodes
import com.example.jpapp.data.roles
import java.util.Locale


@Composable
fun RegistrationPage(navController: NavController, apiService: ApiService,
                     isResettingPassword: Boolean = false) {

    val maroon = Color(0xFF800000)

    var firstName by remember { mutableStateOf(TextFieldValue()) }
    var lastName by remember { mutableStateOf(TextFieldValue()) }
    var nationalId by remember { mutableStateOf(TextFieldValue()) }
    var email by remember { mutableStateOf(TextFieldValue()) }
    var phoneNo by remember { mutableStateOf(TextFieldValue()) }

    var selectedRole by remember { mutableStateOf<Role?>(roles["Select Role"]) }
    var password by remember { mutableStateOf(TextFieldValue()) }
    var confirmPassword by remember { mutableStateOf(TextFieldValue()) }
    var termsAndConditionsChecked by remember { mutableStateOf(false) }
    var isLoading by remember { mutableStateOf(false) }
    var errorMessage by remember { mutableStateOf<String?>(null) }
    var selectedCountryCode by remember { mutableStateOf<CountryCode?>(countryCodes["Country"]) }
    var registrationMessage by remember { mutableStateOf<String?>(null) }
    var showDialog by remember { mutableStateOf(false) }


    fun isValidEmail(email: String): Boolean {
        val emailRegex = Regex("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}\$")
        return emailRegex.matches(email)
    }

    // Assuming this code is part of a ViewModel or similar component

    fun registerUser() {
        if (firstName.text.isEmpty() || lastName.text.isEmpty() || nationalId.text.isEmpty() ||
            email.text.isEmpty() || phoneNo.text.isEmpty() || password.text.isEmpty() || confirmPassword.text.isEmpty()
        ) {
            println("my number: " + phoneNo.text)
            println("fist name: " + phoneNo.text)
            showDialog = true
            errorMessage = "Please fill in all the required fields."
            return
        }

        if (!isValidEmail(email.text)) {
            showDialog = true
            errorMessage = "Invalid email format."
            println(errorMessage)
            return
        }

        if (password.text != confirmPassword.text) {
            showDialog = true
            errorMessage = "Passwords do not match."
            println(errorMessage)
            return
        }

        if (!termsAndConditionsChecked) {
            showDialog = true
            errorMessage = "Please accept the terms and conditions."
            println(errorMessage)
            return
        }

        // If all validation checks pass, proceed with registration
        isLoading = true

        val registrationRequest = RegistrationRequest(
                firstName = firstName.text,
                lastName = lastName.text,
                nationalId = nationalId.text,
                email = email.text,
                phoneNo = phoneNo.text,
                role = selectedRole,
                password = password.text
        )

        // Assuming apiService is correctly configured
        apiService.register(registrationRequest)
            .enqueue(object : Callback<EntityResponse<RegistrationResponse>> {

                override fun onResponse(
                    call: Call<EntityResponse<RegistrationResponse>>,
                    response: Response<EntityResponse<RegistrationResponse>>
                ) {
                    println("registering user")
                    isLoading = false
                    if (response.isSuccessful) {
                        println("sign up sucessful")
                        val entityResponse = response.body()
                        if (entityResponse != null && entityResponse.message == "Sign up successful") {
                            registrationMessage = "Sign up successful"
                            CoroutineScope(Dispatchers.Main).launch {
                                delay(2000) // 2 seconds delay
                                navController.navigate("VerificationPage")
                                println("entity....." + entityResponse)
                            }
                        } else {
                            // Show error message based on the response
                            errorMessage = entityResponse?.message ?: "Unknown error occurred."
                        }
                    } else {
                        // Show error message based on the response code
                        errorMessage = "Failed to register. Please try again later."
                        print(errorMessage)
                        var entity = response.body()
                        println(entity)
                    }
                }

                override fun onFailure(
                    call: Call<EntityResponse<RegistrationResponse>>,
                    t: Throwable
                ) {
                    isLoading = false
                    // Show error message indicating network failure
                    errorMessage = "Network failure: ${t.message}"
                }
            })
    }

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
                TextField(
                        value = firstName,
                        onValueChange = { firstName = it },
                        label = { Text("First Name") },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 16.dp)
                )
                Spacer(modifier = Modifier.height(16.dp))
                TextField(
                        value = lastName,
                        onValueChange = { lastName = it },
                        label = { Text("Last Name") },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 16.dp)
                )
                Spacer(modifier = Modifier.height(16.dp))
                TextField(
                        value = nationalId,
                        onValueChange = { nationalId = it },
                        label = { Text("NationalId") },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 16.dp)
                )
                Spacer(modifier = Modifier.height(16.dp))
                TextField(
                        value = email,
                        onValueChange = { email = it },
                        label = { Text("Your Email") },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 16.dp)
                )
                Spacer(modifier = Modifier.height(16.dp))
                Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 16.dp)
                            .padding(horizontal = 16.dp)
                ) {
                    var expandedCountryCode by remember { mutableStateOf(false) }
                    var selectedCountryCode by remember { mutableStateOf<CountryCode?>(null) }
                    if (expandedCountryCode) {
                        DropdownMenu(
                                expanded = expandedCountryCode,
                                onDismissRequest = { expandedCountryCode = false },
                                modifier = Modifier.fillMaxWidth()
                        ) {
                            // Displaying country codes
                            countryCodes.values.forEach { countryCode ->
                                DropdownMenuItem(
                                        onClick = {
                                            selectedCountryCode = countryCode
                                            expandedCountryCode = false
                                        },
                                        text = countryCode.displayName
                                )
                            }
                        }
                    }

                    Row(verticalAlignment = Alignment.CenterVertically) {
                        selectedCountryCode?.let { Text(it.code, Modifier.weight(1f)) }
                        TextField(
                                value = phoneNo,
                                onValueChange = { phoneNo = it },
                                modifier = Modifier.weight(1f)
                        )

                        Icon(
                                imageVector = Icons.Default.ArrowDropDown,
                                contentDescription = "Dropdown Icon",
                                modifier = Modifier.clickable(onClick = {
                                    expandedCountryCode = !expandedCountryCode
                                })
                        )
                    }
                    Spacer(modifier = Modifier.height(8.dp))

                    // Country Code Dropdown menu implementation
                    if (expandedCountryCode) {
                        DropdownMenu(
                                expanded = expandedCountryCode,
                                onDismissRequest = { expandedCountryCode = false },
                                modifier = Modifier.fillMaxWidth()
                        ) {
                            // Displaying country codes
                            countryCodes.forEach { countryCode ->
                                DropdownMenuItem(
                                        onClick = {
                                            selectedCountryCode = countryCode.value
                                            expandedCountryCode = false
                                        },
                                        text = countryCode.key
                                )
                            }
                        }
                    }
                }
                Spacer(modifier = Modifier.height(16.dp))
                Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 16.dp)
                            .padding(horizontal = 16.dp)
                ) {
                    var expandedRole by remember { mutableStateOf(false) }
                    if (expandedRole) {
                        DropdownMenu(
                                expanded = expandedRole,
                                onDismissRequest = { expandedRole = false },
                                modifier = Modifier.fillMaxWidth()
                        ) {
                            // Displaying roles
                            roles.values.forEach { role ->
                                DropdownMenuItem(
                                        onClick = {
                                            selectedRole = role
                                            expandedRole = false
                                        },
                                        text = role.displayName
                                )
                            }
                        }
                    }

                    Row(verticalAlignment = Alignment.CenterVertically) {
                        selectedRole?.let { Text(it.value, Modifier.weight(1f)) }
                        Icon(
                                imageVector = Icons.Default.ArrowDropDown,
                                contentDescription = "Dropdown Icon",
                                modifier = Modifier.clickable(onClick = {
                                    expandedRole = !expandedRole
                                })
                        )
                    }
                    Spacer(modifier = Modifier.height(8.dp))

                    // Role Dropdown menu implementation
                    if (expandedRole) {
                        DropdownMenu(
                                expanded = expandedRole,
                                onDismissRequest = { expandedRole = false },
                                modifier = Modifier.fillMaxWidth()
                        ) {
                            // Displaying roles
                            roles.forEach { role ->
                                DropdownMenuItem(
                                        onClick = {
                                            selectedRole = role.value
                                            expandedRole = false
                                        },
                                        text = role.key
                                )
                            }
                        }
                    }
                }
                Spacer(modifier = Modifier.height(16.dp))
                TextField(
                        value = password,
                        onValueChange = { password = it },
                        label = { Text("Enter your Password") },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 16.dp),
                        visualTransformation = PasswordVisualTransformation(),
                        keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Next)
                )
                Spacer(modifier = Modifier.height(16.dp))
                TextField(
                        value = confirmPassword,
                        onValueChange = { confirmPassword = it },
                        label = { Text("Confirm your Password") },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 16.dp),
                        visualTransformation = PasswordVisualTransformation(),
                        keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Done)
                )
                errorMessage?.let {
                    Text(
                            text = it,
                            color = Color.Red,
                            modifier = Modifier.padding(vertical = 5.dp)

                    )
                }
                    Spacer(modifier = Modifier.height(16.dp))
                    // Checkbox for terms and policy
                    Row(
                            modifier = Modifier.fillMaxWidth(),
                            verticalAlignment = Alignment.CenterVertically
                    ) {
                        Checkbox(
                                checked = termsAndConditionsChecked,
                                onCheckedChange = { isChecked ->
                                    termsAndConditionsChecked = isChecked
                                },
                                modifier = Modifier.padding(start = 16.dp)
                        )
                        Text(
                                text = "By continuing, you automatically accept our terms & conditions privacy policy and cookies policy",
                                modifier = Modifier.padding(start = 5.dp)
                        )
                    }
                    Spacer(modifier = Modifier.height(16.dp))
                    Box(
                            modifier = Modifier
                                .width(300.dp)
                                .height(50.dp)
                                .background(color = Color.LightGray)
                                .clickable { registerUser() }
                    ) {
                        Text(
                                text = "Sign up",
                                color = maroon,
                                fontSize = 20.sp,
                                style = MaterialTheme.typography.displayMedium,
                                modifier = Modifier.align(Alignment.Center)
                        )
                    }
                registrationMessage?.let {
                    Text(
                            text = it,
                            color = Color.Green,
                            modifier = Modifier.padding(vertical = 5.dp)
                    )
                }
                if (isLoading) {
                    CircularProgressIndicator()
                }



                    Spacer(modifier = Modifier.height(16.dp))
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
                            modifier = Modifier.clickable { navController.navigate("sign in") }
                    )


                }
            }

        }
    }
