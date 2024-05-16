package com.example.jpapp.data

  data class  RegistrationResponse (
    val email:String,
    val  password:String,
    val firstName: String,
    val lastName: String,
    val phoneNo: String,
    val nationalId: String,
    val role: String
)