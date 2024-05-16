package com.example.jpapp.data

data class CountryCode(val displayName: String, val code: String)
val countryCodes = mapOf(
        "Country" to CountryCode("Country", "Country"),
        "USA" to CountryCode("USA (+1)", "+1"),
        "Kenya" to CountryCode("Kenya (+254)", "+254"),
        "Canada" to CountryCode("Canada (+1)", "+1"),
        "UK" to CountryCode("UK (+44)", "+44"),
        "Australia" to CountryCode("Australia (+61)", "+61"),
        "Germany" to CountryCode("Germany (+49)", "+49")
)