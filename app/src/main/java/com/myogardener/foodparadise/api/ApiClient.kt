package com.myogardener.foodparadise.api

import com.myogardener.foodparadise.model.Category
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiClient {

    private val BASE_URL = "https://www.themealdb.com/api/json/v1/1/categories.php/"
                        ///"https://www.themealdb.com/images/category/beef.png"

    private val apiInterface: ApiInterface

    init {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        apiInterface = retrofit.create(ApiInterface::class.java)
    }


}