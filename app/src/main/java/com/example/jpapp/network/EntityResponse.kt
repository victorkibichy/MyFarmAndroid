package com.example.jpapp.network



data class   EntityResponse<T>(
    val entity: T?,
    val message: String,
    val statusCode: Int)
