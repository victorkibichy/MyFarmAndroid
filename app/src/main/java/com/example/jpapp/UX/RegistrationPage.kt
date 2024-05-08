package com.example.jpapp.UX

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
<<<<<<< HEAD
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
=======
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.text.KeyboardOptions
>>>>>>> 5a3b63859dd7cd4578a9c6ddd705755bfeeff234
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.Checkbox
import androidx.compose.material3.DropdownMenu
<<<<<<< HEAD
import androidx.compose.material3.DropdownMenuItem
=======
>>>>>>> 5a3b63859dd7cd4578a9c6ddd705755bfeeff234
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
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
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.jpapp.ApiService
import com.example.jpapp.R
import com.example.jpapp.data.AuthUserResponse
import com.example.jpapp.data.RegistrationRequest
import com.example.jpapp.data.RegistrationResponse
import com.example.jpapp.network.EntityResponse
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response



@Composable
fun RegistrationPage(navController: NavController, apiService: ApiService) {

<<<<<<< HEAD
    fun DropdownMenuItem( onClick: () -> Unit, text: String) {

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
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
=======
    val maroon = Color(0xFF800000)

    var firstName by remember { mutableStateOf(TextFieldValue()) }
    var lastName by remember { mutableStateOf(TextFieldValue()) }
    var nationalID by remember { mutableStateOf(TextFieldValue()) }
    var email by remember { mutableStateOf(TextFieldValue()) }
    var phoneNumber by remember { mutableStateOf(TextFieldValue()) }

    var selectedRole by remember { mutableStateOf("Select Role") }
    var password by remember { mutableStateOf(TextFieldValue()) }
    var confirmPassword by remember { mutableStateOf(TextFieldValue()) }
    var termsAndConditionsChecked by remember { mutableStateOf(false) }
    var isLoading by remember { mutableStateOf(false) }
    var errorMessage by remember { mutableStateOf<String?>(null) }
    var selectedCountryCode by remember { mutableStateOf("Select Country Code") }
    var registrationMessage by remember { mutableStateOf<String?>(null) }
    var showDialog by remember { mutableStateOf(false) }

    fun isValidEmail(email: String): Boolean {
        val emailRegex = Regex("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}\$")
        return emailRegex.matches(email)
    }

    fun performRegistration() {
        // Perform validation checks

        if (firstName.text.isEmpty() || lastName.text.isEmpty() || nationalID.text.isEmpty() ||
            email.text.isEmpty() || phoneNumber.text.isEmpty() || selectedCountryCode.isEmpty() ||
            selectedRole.isEmpty() || password.text.isEmpty() || confirmPassword.text.isEmpty()
        ) {
             showDialog = true
            // Show error message indicating required fields are missing
            errorMessage = "Please fill in all the required fields."
            return
        }

        if (!isValidEmail(email.text)) {
            // Show error message indicating invalid email format
            errorMessage = "Invalid email format."
            return
        }

        if (password.text != confirmPassword.text) {
            // Show error message indicating passwords don't match
            errorMessage = "Passwords do not match."
            return
        }

        if (!termsAndConditionsChecked) {
            // Show error message indicating terms and conditions must be accepted
            errorMessage = "Please accept the terms and conditions."
            return
        }

        // If all validation checks pass, proceed with registration
        // Make API call to register user using the provided information
        // Display loading indicator while waiting for response
        isLoading = true

        val registrationRequest = RegistrationRequest(
                firstName = firstName.text,
                lastName = lastName.text,
                nationalID = nationalID.text,
                email = email.text,
                phoneNumber = phoneNumber.text,
                countryCode = selectedCountryCode,
                role = selectedRole,
                password = password.text
        )

        apiService.register(registrationRequest).enqueue(object : Callback<EntityResponse<RegistrationResponse>> {
                override fun onResponse(
                    call: Call<EntityResponse<RegistrationResponse>>,
                    response: Response<EntityResponse<RegistrationResponse>>
>>>>>>> 5a3b63859dd7cd4578a9c6ddd705755bfeeff234
                ) {
                    isLoading = false
                    if (response.isSuccessful) {
                        val entityResponse = response.body()
                        if (entityResponse != null && entityResponse.message== "Sign up successfull") {

                            registrationMessage = "Sign up successful"
                            CoroutineScope(Dispatchers.Main).launch {
                                delay(2000) // 3 seconds delay
                                navController.navigate("VerificationPage")
                            }
                        } else {
                            // Show error message based on the response
                            errorMessage = entityResponse?.message ?: "Unknown error occurred."
                        }
                    } else {
                        // Show error message based on the response code
                        errorMessage = "Failed to register. Please try again later."
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
<<<<<<< HEAD
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
                    label = { Text(" Your Email") },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp),
                    colors = TextFieldDefaults.textFieldColors(MaterialTheme.colorScheme.background)
                )

                Spacer(modifier = Modifier.height(16.dp))
                @Composable
                fun CountryCodeSelectionTextField() {
                    var expandedCountryCode by remember { mutableStateOf(false) }
                    var selectedCountryCode by remember { mutableStateOf("Select Country Code") }
                    val countryCodes = listOf(
                        "USA (+1)",
                        "Canada (+1)",
                        "UK (+44)",
                        "Australia (+61)",
                        "Germany (+49)"
                    )

                    Column(modifier = Modifier.fillMaxWidth().padding(16.dp)) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                              TextField(
                                value = selectedCountryCode,
                                onValueChange = { newValue ->
                                    selectedCountryCode = newValue
                                    expandedCountryCode = false // Close the dropdown after selection
                                },
                                modifier = Modifier.weight(1f),
                                readOnly = true // Make the TextField read-only to prevent typing directly
                            )
                            Icon(
                                imageVector = Icons.Default.ArrowDropDown,
                                contentDescription = "Dropdown Icon",
                                modifier = Modifier.clickable(onClick = { expandedCountryCode =expandedCountryCode })
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
                                            selectedCountryCode = countryCode
                                            expandedCountryCode = false
                                        },
                                        text = countryCode
                                    )
                                }
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
                    var expandedCategory by remember { mutableStateOf(false) }
                    var selectedCategory by remember { mutableStateOf("Select Category") }
                    val categories =
                        listOf("Farmer", "Buyer", "Agro dealer", "Service provider", "Transporter")

                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Text(selectedCategory, Modifier.weight(1f))
                        Icon(
                            imageVector = Icons.Default.ArrowDropDown,
                            contentDescription = "Dropdown Icon",
                            modifier = Modifier.clickable(onClick = {
                                expandedCategory = !expandedCategory
                            })

=======
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
                            value = nationalID,
                            onValueChange = { nationalID = it },
                            label = { Text("National ID") },
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
                        var selectedCountryCode by remember { mutableStateOf("Select Country Code") }
                        val countryCodes = listOf(
                                "USA (+1)",
                                "Kenya (+254)",
                                "Canada (+1)",
                                "UK (+44)",
                                "Australia (+61)",
                                "Germany (+49)"
>>>>>>> 5a3b63859dd7cd4578a9c6ddd705755bfeeff234
                        )




                            Row(verticalAlignment = Alignment.CenterVertically) {
                                Text(selectedCountryCode, Modifier.weight(1f))
                                TextField(
                                        value = phoneNumber,
                                        onValueChange = { phoneNumber = it },
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
                                                selectedCountryCode = countryCode
                                                expandedCountryCode = false
                                            },
                                            text = countryCode
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
                        val roles = listOf(
                                "Farmer",
                                "Buyer",
                                "Agro dealer",
                                "Service provider",
                                "Transporter"
                        )

                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Text(selectedRole, Modifier.weight(1f))
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
                                                selectedRole = role
                                                expandedRole = false
                                            },
                                            text = role
                                    )
                                }
                            }
                        }
                    }
<<<<<<< HEAD
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
=======
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
                                .clickable { performRegistration() }
                    ) {
                        Text(
                                text = "Sign up",
                                color = maroon,
                                fontSize = 20.sp,
                                style = MaterialTheme.typography.displayMedium,
                                modifier = Modifier.align(Alignment.Center)
                        )
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
>>>>>>> 5a3b63859dd7cd4578a9c6ddd705755bfeeff234
                    )
                }
            }
<<<<<<< HEAD
 

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
                modifier = Modifier.clickable { /* Handle click and navigate to the next screen */ })

        }
    }
}
=======
        }
    }
>>>>>>> 5a3b63859dd7cd4578a9c6ddd705755bfeeff234


