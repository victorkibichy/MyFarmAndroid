
package com.example.jpapp.R


import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jpapp.R
import androidx.compose.foundation.Image



import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.lightColors
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.navigation.NavController

@Composable
fun VerificationPage(navController: NavController) {
    val email: MutableState<TextFieldValue> = remember { mutableStateOf(TextFieldValue("")) }
    val focusRequester = remember { FocusRequester() }

    Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
    ) {
        Image(
                painter = painterResource(id = R.drawable.equitylogo),
                contentDescription = null,
                modifier = Modifier.padding(vertical = 10.dp)
        )
        Text(
                text = "Equifarm",
                color = Color.Red,
                fontSize = 30.sp
        )
        Spacer(modifier = Modifier.height(25.dp))
        Text(
                text = "Enter Verification code",
                modifier = Modifier

                    .padding(bottom = 8.dp), // Adjust padding
                fontSize = 24.sp, // Increase font size
                color = Color.Black // Change text color if needed
        )
        Spacer(modifier = Modifier.height(7.dp))
        Text(
                text = "Enter the verification code we just sent you to your email address,",
                modifier = Modifier.padding(horizontal = 3.dp)
        )
        Spacer(modifier = Modifier.height(25.dp))
        OutlinedTextField(
                value = email.value,
                onValueChange = { newValue -> email.value = newValue },
                label = { androidx.compose.material.Text("Verify") },
                modifier = Modifier
                    .fillMaxWidth()
                    .focusRequester(focusRequester),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email)
        )

        Spacer(modifier = Modifier.height(24.dp))
        Button(
                onClick = {
                    navController.navigate("sign in")
                },
                modifier = Modifier.fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(backgroundColor = Color.Gray) // Change button color to maroon
        ) {
            androidx.compose.material.Text("Verify", color = Color.White) // Set text color to white or any other color for better visibility
        }
    }
}
