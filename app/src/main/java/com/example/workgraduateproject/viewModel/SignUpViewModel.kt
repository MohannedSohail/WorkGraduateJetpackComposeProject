package com.example.workgraduateproject.viewModel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.example.Login
import com.example.example.LoginData
import com.example.myapplication.network.ApiService
import com.example.workgraduateproject.model.SignUp
import com.example.workgraduateproject.model.SignUpData
import kotlinx.coroutines.launch

class SignUpViewModel : ViewModel() {


    var signUpResponse = MutableLiveData<SignUp>()


    fun signUpPost(userName: String, userEmail: String, password: String, phone: String) {
        viewModelScope.launch {


            val apiService = ApiService.getInstance()
            val response = apiService.signUp(userName, userEmail, password, phone)

            signUpResponse.postValue(response.body())


        }
    }

}