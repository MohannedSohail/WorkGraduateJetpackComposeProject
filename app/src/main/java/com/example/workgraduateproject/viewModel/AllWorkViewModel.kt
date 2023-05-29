package com.example.workgraduateproject.viewModel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.network.ApiService
import com.example.workgraduateproject.model.WorkData
import kotlinx.coroutines.launch


class AllWorkViewModel : ViewModel() {

    var workListResponse:List<WorkData> by mutableStateOf(listOf())

    fun getItemsList() {
        viewModelScope.launch {
            val apiService =  ApiService.getInstance()
            val itemList = apiService.getAllWorkData()
            workListResponse = itemList.data



        }
    }



}