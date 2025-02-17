package com.example.example

import com.google.gson.annotations.SerializedName


data class Login(

    @SerializedName("code") var code: Int? = null,
    @SerializedName("success") var success: Boolean? = null,
    @SerializedName("message") var message: String? = null,
    @SerializedName("data") var data: LoginData? = LoginData()

)