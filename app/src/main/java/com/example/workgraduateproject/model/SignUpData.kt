package com.example.workgraduateproject.model

import com.google.gson.annotations.SerializedName


data class SignUpData (

  @SerializedName("name"      ) var name     : String? = null,
  @SerializedName("email"     ) var email    : String? = null,
  @SerializedName("phone"     ) var phone    : String? = null,
  @SerializedName("active"    ) var active   : String? = null,
  @SerializedName("type_user" ) var typeUser : String? = null,
  @SerializedName("token"     ) var token    : String? = null

)