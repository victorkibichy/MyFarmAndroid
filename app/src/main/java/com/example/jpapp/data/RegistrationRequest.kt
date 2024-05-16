package com.example.jpapp.data

import androidx.compose.ui.semantics.Role

data class RegistrationRequest(
     val password: String?,
     val role: String?,
     val phoneNo: String?,
     val email: String?,
     val nationalId: String?,
     val lastName: String?,
     val firstName: String?
)
