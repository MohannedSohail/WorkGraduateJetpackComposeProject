package com.example.myapplication.network

import android.net.Uri
import com.example.example.Data
import com.example.example.Login
import com.example.example.LoginData
import com.example.example.Order
import com.example.workgraduateproject.model.AllWorks
import com.example.workgraduateproject.model.SignUp
import com.example.workgraduateproject.model.SignUpData
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.*
import java.io.File


interface ApiService {
    @GET("all/works")
    suspend fun getAllWorkData(): AllWorks


    @Headers(
        "Authorization:Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJhdWQiOiI5Nzc2N2JmYS1mZWVhLTQ0MTEtOWE0My0wYTliNzE4Y2YwZmEiLCJqdGkiOiI5MThlMjI0YmNlM2QxODgyNDkyMjk0YjUxN2MwMjljZDBhOTBjMjEwZWEzNWI5YjM2YjMwOTA2NDJhOTY1MWVkNmY0MTU4NGJhODdlY2ZhZCIsImlhdCI6MTY4NTM4NDYxNCwibmJmIjoxNjg1Mzg0NjE0LCJleHAiOjE3MTcwMDcwMTQsInN1YiI6IjM2MiIsInNjb3BlcyI6W119.jD4o66VrCivxY3TU5o-zI3nDA8EuY9fPI7uXeCldtpqPxPF4JIl-qeFVIfP0CJO-TWwNTFzzaoCXgzfci2BKvJVdvsIgl705FJn0w8zW_vrhfYSPVSU8oIAHf3HpLuUvy8-eY4GhvKISXDzTKtJEUpTdl8vQm_qJ8EYm-Def0i870CFqMxvuc8VVLYtum6rhYgZF3_QZ2TaycZGBZI_hPZ8HvvD4JmQHOm-kgEvgMqzMtwqjLw4_1sR_I_3chyxznMdf-pubw-P9wIiBSpOe3-vY0XQyB3nZWUZ22QJed0wjEk6paR4XrsGsuvRUdE2aZtjyqIgFwjWY5iszBmfAgkWGOUHndAmG4lsFStpplXQZcN6eow21EXfR3awkww8yNUHPGNaOF6jXkV1dw5RQ_n3a5NlFCmoh3LIkCFHLA0ba4Z4__Oucz-9bCH6COiZEmW-ia5YL4F_EhyLEuEXr3Cd8j9NYUo3goYuAB9IPWG8z9IV3yXjFZYMPyB_24xQafLHbDF0XO4569uEBsZwAIUVd6sGj5Q3juzemH-qBu7W6G0VidY03pAC6AoDAPYr7dJd3vspGJgZPwrkrSmFyuEwCpDT3eD7GXj6fAxaSgzc73TT8OSF16d6y96aPGHQTaVTSmPkY-srb3dNYdM10zGEDoLK5riGJK7g6EJzHE7I"
    )
    @GET("order/un/complete/user")
    suspend fun getUnCompleteOrder(): Order


    @Headers(
        "Authorization:Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJhdWQiOiI5Nzc2N2JmYS1mZWVhLTQ0MTEtOWE0My0wYTliNzE4Y2YwZmEiLCJqdGkiOiI5MThlMjI0YmNlM2QxODgyNDkyMjk0YjUxN2MwMjljZDBhOTBjMjEwZWEzNWI5YjM2YjMwOTA2NDJhOTY1MWVkNmY0MTU4NGJhODdlY2ZhZCIsImlhdCI6MTY4NTM4NDYxNCwibmJmIjoxNjg1Mzg0NjE0LCJleHAiOjE3MTcwMDcwMTQsInN1YiI6IjM2MiIsInNjb3BlcyI6W119.jD4o66VrCivxY3TU5o-zI3nDA8EuY9fPI7uXeCldtpqPxPF4JIl-qeFVIfP0CJO-TWwNTFzzaoCXgzfci2BKvJVdvsIgl705FJn0w8zW_vrhfYSPVSU8oIAHf3HpLuUvy8-eY4GhvKISXDzTKtJEUpTdl8vQm_qJ8EYm-Def0i870CFqMxvuc8VVLYtum6rhYgZF3_QZ2TaycZGBZI_hPZ8HvvD4JmQHOm-kgEvgMqzMtwqjLw4_1sR_I_3chyxznMdf-pubw-P9wIiBSpOe3-vY0XQyB3nZWUZ22QJed0wjEk6paR4XrsGsuvRUdE2aZtjyqIgFwjWY5iszBmfAgkWGOUHndAmG4lsFStpplXQZcN6eow21EXfR3awkww8yNUHPGNaOF6jXkV1dw5RQ_n3a5NlFCmoh3LIkCFHLA0ba4Z4__Oucz-9bCH6COiZEmW-ia5YL4F_EhyLEuEXr3Cd8j9NYUo3goYuAB9IPWG8z9IV3yXjFZYMPyB_24xQafLHbDF0XO4569uEBsZwAIUVd6sGj5Q3juzemH-qBu7W6G0VidY03pAC6AoDAPYr7dJd3vspGJgZPwrkrSmFyuEwCpDT3eD7GXj6fAxaSgzc73TT8OSF16d6y96aPGHQTaVTSmPkY-srb3dNYdM10zGEDoLK5riGJK7g6EJzHE7I"
    )
    @GET("order/complete/user")
    suspend fun getCompleteOrder(): Order


    @Headers(
        "Authorization:Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJhdWQiOiI5Nzc2N2JmYS1mZWVhLTQ0MTEtOWE0My0wYTliNzE4Y2YwZmEiLCJqdGkiOiI5MThlMjI0YmNlM2QxODgyNDkyMjk0YjUxN2MwMjljZDBhOTBjMjEwZWEzNWI5YjM2YjMwOTA2NDJhOTY1MWVkNmY0MTU4NGJhODdlY2ZhZCIsImlhdCI6MTY4NTM4NDYxNCwibmJmIjoxNjg1Mzg0NjE0LCJleHAiOjE3MTcwMDcwMTQsInN1YiI6IjM2MiIsInNjb3BlcyI6W119.jD4o66VrCivxY3TU5o-zI3nDA8EuY9fPI7uXeCldtpqPxPF4JIl-qeFVIfP0CJO-TWwNTFzzaoCXgzfci2BKvJVdvsIgl705FJn0w8zW_vrhfYSPVSU8oIAHf3HpLuUvy8-eY4GhvKISXDzTKtJEUpTdl8vQm_qJ8EYm-Def0i870CFqMxvuc8VVLYtum6rhYgZF3_QZ2TaycZGBZI_hPZ8HvvD4JmQHOm-kgEvgMqzMtwqjLw4_1sR_I_3chyxznMdf-pubw-P9wIiBSpOe3-vY0XQyB3nZWUZ22QJed0wjEk6paR4XrsGsuvRUdE2aZtjyqIgFwjWY5iszBmfAgkWGOUHndAmG4lsFStpplXQZcN6eow21EXfR3awkww8yNUHPGNaOF6jXkV1dw5RQ_n3a5NlFCmoh3LIkCFHLA0ba4Z4__Oucz-9bCH6COiZEmW-ia5YL4F_EhyLEuEXr3Cd8j9NYUo3goYuAB9IPWG8z9IV3yXjFZYMPyB_24xQafLHbDF0XO4569uEBsZwAIUVd6sGj5Q3juzemH-qBu7W6G0VidY03pAC6AoDAPYr7dJd3vspGJgZPwrkrSmFyuEwCpDT3eD7GXj6fAxaSgzc73TT8OSF16d6y96aPGHQTaVTSmPkY-srb3dNYdM10zGEDoLK5riGJK7g6EJzHE7I"
    )
    @GET("order/pending/user")
    suspend fun getPendingOrder(): Order

    @FormUrlEncoded
    @POST("auth/login/user")
    suspend fun login(
        @Field("email") userEmail: String,
        @Field("password") password: String,
    ): Response<Login>

    @FormUrlEncoded
    @POST("auth/register/user")
    suspend fun signUp(
        @Field("name") userName: String,
        @Field("email") userEmail: String,
        @Field("password") password: String,
        @Field("phone") phone: String,
    ): Response<SignUp>


    @Headers(
        "Authorization:Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJhdWQiOiI5Nzc2N2JmYS1mZWVhLTQ0MTEtOWE0My0wYTliNzE4Y2YwZmEiLCJqdGkiOiI5MThlMjI0YmNlM2QxODgyNDkyMjk0YjUxN2MwMjljZDBhOTBjMjEwZWEzNWI5YjM2YjMwOTA2NDJhOTY1MWVkNmY0MTU4NGJhODdlY2ZhZCIsImlhdCI6MTY4NTM4NDYxNCwibmJmIjoxNjg1Mzg0NjE0LCJleHAiOjE3MTcwMDcwMTQsInN1YiI6IjM2MiIsInNjb3BlcyI6W119.jD4o66VrCivxY3TU5o-zI3nDA8EuY9fPI7uXeCldtpqPxPF4JIl-qeFVIfP0CJO-TWwNTFzzaoCXgzfci2BKvJVdvsIgl705FJn0w8zW_vrhfYSPVSU8oIAHf3HpLuUvy8-eY4GhvKISXDzTKtJEUpTdl8vQm_qJ8EYm-Def0i870CFqMxvuc8VVLYtum6rhYgZF3_QZ2TaycZGBZI_hPZ8HvvD4JmQHOm-kgEvgMqzMtwqjLw4_1sR_I_3chyxznMdf-pubw-P9wIiBSpOe3-vY0XQyB3nZWUZ22QJed0wjEk6paR4XrsGsuvRUdE2aZtjyqIgFwjWY5iszBmfAgkWGOUHndAmG4lsFStpplXQZcN6eow21EXfR3awkww8yNUHPGNaOF6jXkV1dw5RQ_n3a5NlFCmoh3LIkCFHLA0ba4Z4__Oucz-9bCH6COiZEmW-ia5YL4F_EhyLEuEXr3Cd8j9NYUo3goYuAB9IPWG8z9IV3yXjFZYMPyB_24xQafLHbDF0XO4569uEBsZwAIUVd6sGj5Q3juzemH-qBu7W6G0VidY03pAC6AoDAPYr7dJd3vspGJgZPwrkrSmFyuEwCpDT3eD7GXj6fAxaSgzc73TT8OSF16d6y96aPGHQTaVTSmPkY-srb3dNYdM10zGEDoLK5riGJK7g6EJzHE7I"
    )
    @POST("create/order")
    suspend fun createOrder(
        @Field("work_id") workId: Int,
        @Field("details") details: String,
        @Field("details_address") detailsAddress: String,
        @Field("photos") photos: File,
        @Field("phone") phone: String,
        @Field("lat") lat: Float,
        @Field("long") long: Float,
    ): Response<Order>

    companion object {
        var apiService: ApiService? = null
        fun getInstance(): ApiService {
            if (apiService == null) {
                apiService = Retrofit.Builder()
                    .baseUrl("https://studentucas.awamr.com/api/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build().create(ApiService::class.java)
            }
            return apiService!!
        }
    }


}

