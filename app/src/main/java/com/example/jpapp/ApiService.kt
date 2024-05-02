package com.example.jpapp
import com.example.jpapp.data.AuthUser
import com.example.jpapp.network.EntityResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiService {

    @POST("auth/authenticate")
    fun signin (@Body loginRequest:AuthUser ): Call<EntityResponse<AuthUser>>}


