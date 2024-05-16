package com.example.jpapp.data

data class ApiResponse<T>(
    val entity: T,
    val message: String,
    val statusCode: Int
)