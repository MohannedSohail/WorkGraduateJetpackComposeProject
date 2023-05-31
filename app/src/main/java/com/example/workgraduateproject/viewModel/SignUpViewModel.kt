package com.example.workgraduateproject.viewModel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.example.LoginData
import com.example.myapplication.network.ApiService
import com.example.workgraduateproject.model.SignUpData
import kotlinx.coroutines.launch

class SignUpViewModel:ViewModel() {


    var signUpResponse: SignUpData by mutableStateOf(SignUpData())


    fun signUpPost(userName: String, userEmail: String,password: String , phone: String) {
        viewModelScope.launch {



            val apiService = ApiService.getInstance()
            val response = apiService.signUp(userName,userEmail,password,phone )

            signUpResponse = response.body()!!.data!!



        }
    }


}