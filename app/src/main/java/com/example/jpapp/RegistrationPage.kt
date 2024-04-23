package com.example.jpapp

import androidx.compose.runtime.Composable
import androidx.compose.foundation.Image
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Checkbox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
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
