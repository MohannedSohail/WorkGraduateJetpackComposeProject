package com.example.myapplication.network

import com.example.example.Login
import com.example.example.Order
import com.example.workgraduateproject.model.AllWorks
import com.example.workgraduateproject.model.SignUp
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.*


interface ApiService {
    @GET("all/works")
    suspend fun getAllWorkData(): AllWorks


//    @Headers(
//        "Authorization:Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJhdWQiOiI5Nzc2N2JmYS1mZWVhLTQ0MTEtOWE0My0wYTliNzE4Y2YwZmEiLCJqdGkiOiI5MThlMjI0YmNlM2QxODgyNDkyMjk0YjUxN2MwMjljZDBhOTBjMjEwZWEzNWI5YjM2YjMwOTA2NDJhOTY1MWVkNmY0MTU4NGJhODdlY2ZhZCIsImlhdCI6MTY4NTM4NDYxNCwibmJmIjoxNjg1Mzg0NjE0LCJleHAiOjE3MTcwMDcwMTQsInN1YiI6IjM2MiIsInNjb3BlcyI6W119.jD4o66VrCivxY3TU5o-zI3nDA8EuY9fPI7uXeCldtpqPxPF4JIl-qeFVIfP0CJO-TWwNTFzzaoCXgzfci2BKvJVdvsIgl705FJn0w8zW_vrhfYSPVSU8oIAHf3HpLuUvy8-eY4GhvKISXDzTKtJEUpTdl8vQm_qJ8EYm-Def0i870CFqMxvuc8VVLYtum6rhYgZF3_QZ2TaycZGBZI_hPZ8HvvD4JmQHOm-kgEvgMqzMtwqjLw4_1sR_I_3chyxznMdf-pubw-P9wIiBSpOe3-vY0XQyB3nZWUZ22QJed0wjEk6paR4XrsGsuvRUdE2aZtjyqIgFwjWY5iszBmfAgkWGOUHndAmG4lsFStpplXQZcN6eow21EXfR3awkww8yNUHPGNaOF6jXkV1dw5RQ_n3a5NlFCmoh3LIkCFHLA0ba4Z4__Oucz-9bCH6COiZEmW-ia5YL4F_EhyLEuEXr3Cd8j9NYUo3goYuAB9IPWG8z9IV3yXjFZYMPyB_24xQafLHbDF0XO4569uEBsZwAIUVd6sGj5Q3juzemH-qBu7W6G0VidY03pAC6AoDAPYr7dJd3vspGJgZPwrkrSmFyuEwCpDT3eD7GXj6fAxaSgzc73TT8OSF16d6y96aPGHQTaVTSmPkY-srb3dNYdM10zGEDoLK5riGJK7g6EJzHE7I"
//    )
    @GET("order/un/complete/user")
    suspend fun getUnCompleteOrder(
    @Header("Authorization") token: String,

    ): Order


//    @Headers(
//        "Authorization:Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJhdWQiOiI5Nzc2N2JmYS1mZWVhLTQ0MTEtOWE0My0wYTliNzE4Y2YwZmEiLCJqdGkiOiI5MThlMjI0YmNlM2QxODgyNDkyMjk0YjUxN2MwMjljZDBhOTBjMjEwZWEzNWI5YjM2YjMwOTA2NDJhOTY1MWVkNmY0MTU4NGJhODdlY2ZhZCIsImlhdCI6MTY4NTM4NDYxNCwibmJmIjoxNjg1Mzg0NjE0LCJleHAiOjE3MTcwMDcwMTQsInN1YiI6IjM2MiIsInNjb3BlcyI6W119.jD4o66VrCivxY3TU5o-zI3nDA8EuY9fPI7uXeCldtpqPxPF4JIl-qeFVIfP0CJO-TWwNTFzzaoCXgzfci2BKvJVdvsIgl705FJn0w8zW_vrhfYSPVSU8oIAHf3HpLuUvy8-eY4GhvKISXDzTKtJEUpTdl8vQm_qJ8EYm-Def0i870CFqMxvuc8VVLYtum6rhYgZF3_QZ2TaycZGBZI_hPZ8HvvD4JmQHOm-kgEvgMqzMtwqjLw4_1sR_I_3chyxznMdf-pubw-P9wIiBSpOe3-vY0XQyB3nZWUZ22QJed0wjEk6paR4XrsGsuvRUdE2aZtjyqIgFwjWY5iszBmfAgkWGOUHndAmG4lsFStpplXQZcN6eow21EXfR3awkww8yNUHPGNaOF6jXkV1dw5RQ_n3a5NlFCmoh3LIkCFHLA0ba4Z4__Oucz-9bCH6COiZEmW-ia5YL4F_EhyLEuEXr3Cd8j9NYUo3goYuAB9IPWG8z9IV3yXjFZYMPyB_24xQafLHbDF0XO4569uEBsZwAIUVd6sGj5Q3juzemH-qBu7W6G0VidY03pAC6AoDAPYr7dJd3vspGJgZPwrkrSmFyuEwCpDT3eD7GXj6fAxaSgzc73TT8OSF16d6y96aPGHQTaVTSmPkY-srb3dNYdM10zGEDoLK5riGJK7g6EJzHE7I"
//    )
    @GET("order/complete/user")
    suspend fun getCompleteOrder(
    @Header("Authorization") token: String,

    ): Order


//    @Headers(
//        "Authorization:Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJhdWQiOiI5Nzc2N2JmYS1mZWVhLTQ0MTEtOWE0My0wYTliNzE4Y2YwZmEiLCJqdGkiOiI5MThlMjI0YmNlM2QxODgyNDkyMjk0YjUxN2MwMjljZDBhOTBjMjEwZWEzNWI5YjM2YjMwOTA2NDJhOTY1MWVkNmY0MTU4NGJhODdlY2ZhZCIsImlhdCI6MTY4NTM4NDYxNCwibmJmIjoxNjg1Mzg0NjE0LCJleHAiOjE3MTcwMDcwMTQsInN1YiI6IjM2MiIsInNjb3BlcyI6W119.jD4o66VrCivxY3TU5o-zI3nDA8EuY9fPI7uXeCldtpqPxPF4JIl-qeFVIfP0CJO-TWwNTFzzaoCXgzfci2BKvJVdvsIgl705FJn0w8zW_vrhfYSPVSU8oIAHf3HpLuUvy8-eY4GhvKISXDzTKtJEUpTdl8vQm_qJ8EYm-Def0i870CFqMxvuc8VVLYtum6rhYgZF3_QZ2TaycZGBZI_hPZ8HvvD4JmQHOm-kgEvgMqzMtwqjLw4_1sR_I_3chyxznMdf-pubw-P9wIiBSpOe3-vY0XQyB3nZWUZ22QJed0wjEk6paR4XrsGsuvRUdE2aZtjyqIgFwjWY5iszBmfAgkWGOUHndAmG4lsFStpplXQZcN6eow21EXfR3awkww8yNUHPGNaOF6jXkV1dw5RQ_n3a5NlFCmoh3LIkCFHLA0ba4Z4__Oucz-9bCH6COiZEmW-ia5YL4F_EhyLEuEXr3Cd8j9NYUo3goYuAB9IPWG8z9IV3yXjFZYMPyB_24xQafLHbDF0XO4569uEBsZwAIUVd6sGj5Q3juzemH-qBu7W6G0VidY03pAC6AoDAPYr7dJd3vspGJgZPwrkrSmFyuEwCpDT3eD7GXj6fAxaSgzc73TT8OSF16d6y96aPGHQTaVTSmPkY-srb3dNYdM10zGEDoLK5riGJK7g6EJzHE7I"
//    )
    @GET("order/pending/user")
    suspend fun getPendingOrder(
    @Header("Authorization") token: String,

    ): Order

    @FormUrlEncoded
    @POST("auth/login/user")
    suspend fun login(
        @Field("email") userEmail: String,
        @Field("password") password: String,
    ): Response<Login?>

    @FormUrlEncoded
    @POST("auth/register/user")
    suspend fun signUp(
        @Field("name") userName: String,
        @Field("email") userEmail: String,
        @Field("password") password: String,
        @Field("phone") phone: String,
    ): Response<SignUp>


    //    @Headers(
//        "Authorization:Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJhdWQiOiI5Nzc2N2JmYS1mZWVhLTQ0MTEtOWE0My0wYTliNzE4Y2YwZmEiLCJqdGkiOiJiYzQwZmI5NWNhZTJlMGNmMDc0MjAxZDcxMmFmNGIyMTczMDg1NTdmNWQ1MjgxZWY3OTAxMDEyMzBlMzdkMDYxMDUyNjY3NDNhYWNkNmEwZiIsImlhdCI6MTY4NjA1Njk4OSwibmJmIjoxNjg2MDU2OTg5LCJleHAiOjE3MTc2NzkzODksInN1YiI6IjM2MiIsInNjb3BlcyI6W119.H0MCveD5M8y6qwG3o6afJLyaeVhNVDVgV-aKprywjR5vaJgB6xSATzt4wv-NTwESJ7cgesAj-20ZEar5hmIEzW3LFoDiaDuljgGMBL_nnWHex4y7DM6OaDXfWvoslPIj2ErLcjG-99JCT47Kiqh-1uFzvJp6zr62Q4oa7i8s37Bs03mlqGbqnjxNZtp90KsqpLw45Jlu7Fw9SsKWjpyP8k0_lLPDowG4xnvJnXQnKjo74FLamj8GVkidh-JMC1syAiCTjchakP0i8n21wQ5Rz0LRXRwJsgQz_KSgSzGtk_jycaO7W-XAEgsXphNfANu5hM8_fMokPT_cFVhCpo7r8UHZ6h6I0EkIFPjpKilaI_xdsMkYxN9ap5sglXgvHMouJL9rx_0ymPesDnxJtLPayzZNQAV15Ww17GcPDDT8g0WPNp00-XKcHm-AILdg952ZkidVm5hVBtvJD9bCRwHoPaoPwYfqm07n2pYvaWtFC29qVuV_IEmCl7yMhQnmqIrtyIqc1_8BAF9ReilVAwUscllK_Oh-vr8bZx4h2yMpquEvbUJ86zcvPyLMigjVOMEBPl_fYMOW9BSSi011s5u93dWJyt4YZj-sVbFfbgG2DafkhxQYQU339LbX64iwMo4G_wfZ4hsdeYxrsh3g6O2YZI5dCgRBqalJj6fp05CVZxE"
//    )
    @Multipart
    @POST("create/order")
    suspend fun createOrder(
        @Header("Authorization") token: String,

        @Part("work_id") workId: RequestBody,
        @Part("details") details: RequestBody,
        @Part("details_address") detailsAddress: RequestBody,
//        @Part photos: List<MultipartBody.Part>,
        @Part("phone") phone: RequestBody,
        @Part("lat") lat: RequestBody,
        @Part("long") long: RequestBody,
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

