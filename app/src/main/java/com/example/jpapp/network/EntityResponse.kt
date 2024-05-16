package com.example.jpapp.network

import com.example.jpapp.data.RegistrationResponse

data class EntityResponse<T>(
    val entity: T?,
    val message: String?,
    val statusCode: Int
)


