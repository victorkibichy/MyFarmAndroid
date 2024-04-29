package com.example.jpapp.UX

    import androidx.compose.foundation.layout.*
    import androidx.compose.material.*
    import androidx.compose.runtime.*
    import androidx.compose.ui.Alignment
    import androidx.compose.ui.Modifier
    import androidx.compose.ui.unit.dp
    import androidx.navigation.NavController

@Composable
fun TransportScreen(navController: NavController) {
    var pickupAddress by remember { mutableStateOf("") }
    var deliveryAddress by remember { mutableStateOf("") }
    var trackingNumber by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        // Input fields for pickup and delivery addresses
        TextField(
            value = pickupAddress,
            onValueChange = { pickupAddress = it },
            label = { Text("Pickup Address") },
            modifier = Modifier.fillMaxWidth()
        )

        TextField(
            value = deliveryAddress,
            onValueChange = { deliveryAddress = it },
            label = { Text("Delivery Address") },
            modifier = Modifier.fillMaxWidth()
        )

        // Input field for tracking number
        TextField(
            value = trackingNumber,
            onValueChange = { trackingNumber = it },
            label = { Text("Tracking Number") },
            modifier = Modifier.fillMaxWidth()
        )

        // Button to initiate tracking
        Button(
            onClick = {
                // Perform tracking action here
                // You can implement the logic to track the shipment
            },
            modifier = Modifier.align(Alignment.End)
        ) {
            Text("Track Shipment")
        }
    }
}
