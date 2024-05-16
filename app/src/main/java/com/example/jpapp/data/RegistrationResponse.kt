package com.example.jpapp.data

data class RegistrationResponse (
    val access_token: String,
    val active: Boolean,
    val createdAt: String,
    val email: String,
    val firstName: String,
    val id: Int,
    val isAdmin: Boolean,
    val isStaff: Boolean,
    val lastName: String,
    val nationalId: String,
    val phoneNo: String,
    val refresh_token: String,
    val role: String,
    val tokenType: String,
    val updatedAt: Any
)