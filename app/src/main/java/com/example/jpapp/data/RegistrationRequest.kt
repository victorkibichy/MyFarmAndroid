package com.example.jpapp.data

 data class RegistrationRequest(
     val password: String?,
     val role: String?,
     val phoneNo: String?,
     val email: String?,
     val nationalId: String?,
     val lastName: String?,
     val firstName: String?
)
