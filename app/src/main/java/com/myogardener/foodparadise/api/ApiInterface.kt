package com.myogardener.foodparadise.api

import com.myogardener.foodparadise.model.Category
import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface{
@GET("categories")
fun getPost(): Call<ArrayList<Category>>
}