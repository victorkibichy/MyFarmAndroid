package com.example.jpapp.data

 data class RegistrationRequest(
     val password: String,
     val role: String,
     val countryCode: String,
     val phoneNumber: String,
     val email: String,
     val nationalID: String,
     val lastName: String,
     val firstName: String
)
