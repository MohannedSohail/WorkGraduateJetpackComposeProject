package com.example.workgraduateproject.model

import com.google.gson.annotations.SerializedName


data class SignUp (

  @SerializedName("code"    ) var code    : Int?     = null,
  @SerializedName("success" ) var success : Boolean? = null,
  @SerializedName("message" ) var message : String?  = null,
  @SerializedName("data"    ) var data    : SignUpData?    = SignUpData()

)