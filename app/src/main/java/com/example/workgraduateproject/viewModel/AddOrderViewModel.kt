package com.example.workgraduateproject.viewModel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.example.Data
import com.example.myapplication.network.ApiService
import kotlinx.coroutines.launch
import java.io.File

class AddOrderViewModel : ViewModel() {


    var addOrderResponse: List<Data> by mutableStateOf(listOf())


    fun addOrderPost(
        workId: Int,
        details: String,
        addressDetails: String,
        photos: File,
        phone: String,
        lat: Float,
        long: Float
    ) {

        viewModelScope.launch {

            val apiService = ApiService.getInstance()
            val response =
                apiService.createOrder(workId, details, addressDetails, photos, phone, lat, long)


            addOrderResponse= response.body()!!.data
        }

    }

}