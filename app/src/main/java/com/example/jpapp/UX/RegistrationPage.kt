package com.example.jpapp.UX

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.Checkbox
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
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
import androidx.navigation.NavController
import com.example.jpapp.R


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RegistrationPage(navController: NavController) {

    val maroon = Color(0xFF800000)

    var firstName by remember { mutableStateOf("") }
    var lastName by remember { mutableStateOf("") }
    var nationalID by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var phonenumber by remember { mutableStateOf("") }
    var selectedCountryCode by remember { mutableStateOf("+254") }
    var selectedCategory by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var confirmPassword by remember { mutableStateOf("") }
    var termsAndConditionsChecked by remember { mutableStateOf(false) }

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
                            value = firstName,
                            onValueChange = { newTextvalue -> firstName = newTextvalue },
                            label = { Text("First Name") },
                            modifier = Modifier
                                .weight(1f)
                                .padding(start = 16.dp),
                            colors = TextFieldDefaults.textFieldColors(MaterialTheme.colorScheme.onBackground)
                    )
                    Spacer(modifier = Modifier.width(16.dp)) // Line break
                    TextField(
                            value = lastName,
                            onValueChange = { newTextvalue -> lastName = newTextvalue },
                            label = { Text("Last Name") },
                            modifier = Modifier
                                .weight(1f)
                                .padding(end = 16.dp),
                            colors = TextFieldDefaults.textFieldColors(MaterialTheme.colorScheme.onBackground)
                    )
                }
                Spacer(modifier = Modifier.height(16.dp))
                TextField(
                        value = nationalID,
                        onValueChange = { newTextvalue -> nationalID = newTextvalue },
                        label = { Text("National ID") },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 16.dp),
                        colors = TextFieldDefaults.textFieldColors(MaterialTheme.colorScheme.onBackground)
                )
                Spacer(modifier = Modifier.height(16.dp))
                TextField(
                        value = email,
                        onValueChange = { newTextvalue -> email = newTextvalue },
                        label = { Text(" Your Email") },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 16.dp),
                        colors = TextFieldDefaults.textFieldColors(MaterialTheme.colorScheme.onBackground)
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
                    val countryCodes = listOf("USA (+1)","Kenya (+254)", "Canada (+1)", "UK (+44)", "Australia (+61)", "Germany (+49)")
                    var phoneNumber by remember { mutableStateOf("") }

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
                    var selectedRole by remember { mutableStateOf("Select Role") }
                    val roles =
                        listOf("Farmer", "Buyer", "Agro dealer", "Service provider", "Transporter")

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


                Spacer(modifier = Modifier.height(16.dp))

                TextField(
                        value = password,
                        onValueChange = { newTextvalue -> password = newTextvalue },
                        label = { Text("Enter your Password") },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 16.dp),
                        colors = TextFieldDefaults.textFieldColors(MaterialTheme.colorScheme.onBackground),
                        visualTransformation = PasswordVisualTransformation(),
                        keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Next),
                        keyboardActions = KeyboardActions(onNext = { /* Handle next action here */ })
                )
                Spacer(modifier = Modifier.height(16.dp))
                TextField(
                        value = confirmPassword,
                        onValueChange = { newTextvalue -> confirmPassword = newTextvalue },
                        label = { Text("Confirm your Password") },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 16.dp),
                        colors = TextFieldDefaults.textFieldColors(MaterialTheme.colorScheme.onBackground),
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
                Spacer(modifier = Modifier.height(10.dp))
                Box(
                        modifier = Modifier
                            .width(300.dp)
                            .height(50.dp)
                            .background(color = Color.LightGray)
                            .clickable {
                                navController.navigate("VerificationPage")
                            }
                ) {

                    Text(
                            text = "Sign up",
                            color = maroon,
                            fontSize = 20.sp,
                            style = MaterialTheme.typography.displayMedium,
                            modifier = Modifier.align(Alignment.Center)
                    )
                }


            }

            Spacer(modifier = Modifier.height(7.dp))

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
                    modifier = Modifier.clickable {  navController.navigate("sign in")}
            )
        }
    }

}