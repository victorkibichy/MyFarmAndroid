package com.example.jpapp.data


data class Role(val displayName: String, val value: String)
val roles = mapOf(
        "Select Role" to Role("Select Role", "Select Role"),
        "Farmer" to Role("Farmer", "FARMER"),
        "Buyer" to Role("Buyer", "CUSTOMER"),
        "Agro Dealer" to Role("Agro Dealer", "AGRIBUSINESS_OWNER"),
        "Service Provider" to Role("Service Provider", "SERVICE_PROVIDER"),
        "Transporter" to Role("Transporter", "TRANSPORTER"),
        "Farm Tech" to Role("Farm Tech", "FARMTECH_OWNER"),
        "Driver" to Role("Driver", "DRIVER")
)