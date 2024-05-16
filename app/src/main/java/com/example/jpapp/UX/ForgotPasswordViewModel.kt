package com.example.jpapp.UX

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

    class ForgotPasswordViewModel : ViewModel() {
        fun resetPassword(email: String) {
            viewModelScope.launch {
            }
        }
    }

