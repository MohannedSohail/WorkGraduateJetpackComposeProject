package com.example.workgraduateproject.viewModel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.example.Order
import com.example.myapplication.network.ApiService
import kotlinx.coroutines.launch
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.MultipartBody
import okhttp3.RequestBody.Companion.asRequestBody
import okhttp3.RequestBody.Companion.toRequestBody
import java.io.File

class AddOrderViewModel : ViewModel() {


    var addOrder = MutableLiveData<Order>()


    fun addOrderPost(
        workId: Int,
        details: String,
        addressDetails: String,
        photos: List<File>,
        phone: String,
        lat: Float,
        long: Float,
        token: String,

        ) {

        viewModelScope.launch {

            val apiService = ApiService.getInstance()


            val workIdRb = workId.toString().toRequestBody("text/plain".toMediaType())
            val detailsRb = details.toRequestBody("text/plain".toMediaType())
            val detailsAddressRb = addressDetails.toRequestBody("text/plain".toMediaType())
            val phoneRb = phone.toRequestBody("text/plain".toMediaType())
            val latRb = lat.toString().toRequestBody("text/plain".toMediaType())
            val longRb = long.toString().toRequestBody("text/plain".toMediaType())

            val photosRb: List<MultipartBody.Part> = photos.map { file ->
                val requestBody = file.asRequestBody("image/*".toMediaType())
                MultipartBody.Part.createFormData("photos", file.name, requestBody)
            }


            val response =
                apiService.createOrder(
                    token,
                    workIdRb,
                    detailsRb,
                    detailsAddressRb,
//                    photosRb,
                    phoneRb,
                    latRb,
                    longRb
                )
//            val response =
//                apiService.createOrder(
//                    workIdRb,
//                    detailsRb,
//                    detailsAddressRb,
//                    phoneRb,
//                    latRb,
//                    longRb
//                )


            Log.d("MyResponse", response.body().toString())


            addOrder.postValue(response.body())
        }

    }

}