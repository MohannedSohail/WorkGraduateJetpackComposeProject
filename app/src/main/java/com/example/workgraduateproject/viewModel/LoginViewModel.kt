package com.example.workgraduateproject.viewModel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.example.Data
import com.example.example.Login
import com.example.example.LoginData
import com.example.myapplication.network.ApiService
import com.example.workgraduateproject.model.WorkData
import kotlinx.coroutines.launch
import retrofit2.Response
import retrofit2.http.Field

class LoginViewModel : ViewModel() {
     var loginResponse:LoginData by mutableStateOf(LoginData())

//     val _loginResult = MutableLiveData<Result<Login>>()
//    val loginResult: LiveData<Result<Login>> = _loginResult

    fun loginPost(userEmail: String, password: String) {
        viewModelScope.launch {



            val apiService = ApiService.getInstance()
            val response = apiService.login(userEmail, password)

//            _loginResult.value= Result.success(response.body()!!)
            loginResponse = response.body()!!.data!!



        }
    }


}

