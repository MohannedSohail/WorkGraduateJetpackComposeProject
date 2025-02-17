package com.example.workgraduateproject.viewModel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.example.Data
import com.example.myapplication.network.ApiService
import com.example.workgraduateproject.model.WorkData
import kotlinx.coroutines.launch


class OrdersViewModel : ViewModel() {

    var completeOrderListResponse: List<Data> by mutableStateOf(listOf())
    var unCompleteOrderListResponse: List<Data> by mutableStateOf(listOf())
    var pendingOrderListResponse: List<Data> by mutableStateOf(listOf())

    fun getUnCompleteOrderList(
        token: String,
    ) {
        viewModelScope.launch {
            val apiService = ApiService.getInstance()
            val itemList = apiService.getUnCompleteOrder(token)
            unCompleteOrderListResponse = itemList.data


        }
    }

    fun getCompleteOrderList(
        token: String,
    ) {
        viewModelScope.launch {
            val apiService = ApiService.getInstance()
            val itemList = apiService.getCompleteOrder(token)
            completeOrderListResponse = itemList.data


        }
    }


    fun getPendingOrderList(
        token: String,
    ) {
        viewModelScope.launch {
            val apiService = ApiService.getInstance()
            val itemList = apiService.getPendingOrder(token)
            pendingOrderListResponse = itemList.data


        }
    }


}