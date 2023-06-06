package com.example.workgraduateproject.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.example.Login
import com.example.myapplication.network.ApiService
import kotlinx.coroutines.launch

class LoginViewModel : ViewModel() {
    var loginResponse = MutableLiveData<Login>()
//    var loginResponse = MutableLiveData<ViewState<Login>>()

    fun loginPost(userEmail: String, password: String) {
        viewModelScope.launch {

//            if (true){
//                loginResponse.postValue(ViewState.Error("Lozza"))
//                return@launch
//
//            }
//            loginResponse.postValue(ViewState.Loading())


       val apiService = ApiService.getInstance()
            val response = apiService.login(userEmail, password)


//            if(loginResponse.value?.value?.data?.active=="مفعل")
//            response.body()?.let {
//                loginResponse.postValue(ViewState.Success(it))
//
//            }


            loginResponse.postValue(response.body())




        }
    }


}

