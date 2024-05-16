package com.example.jpapp
import com.example.jpapp.data.AuthUserRequest
import com.example.jpapp.data.AuthUserResponse
import com.example.jpapp.data.RegistrationRequest
import com.example.jpapp.data.RegistrationResponse


import com.example.jpapp.network.EntityResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiService {

    @POST("auth/authenticate")
    fun signin (@Body loginRequest:AuthUserRequest ): Call<EntityResponse<AuthUserResponse>>
    @POST("auth/register")
    fun register(@Body registrationRequest:RegistrationRequest): Call<EntityResponse<RegistrationResponse>>
}


