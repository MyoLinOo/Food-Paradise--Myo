package com.myogardener.foodparadise.api

import com.myogardener.foodparadise.model.Categories
import com.myogardener.foodparadise.model.Category
import com.myogardener.foodparadise.model.SingleCategory
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface{
@GET("categories.php")
fun getPost(): Call<Categories>

    @GET("filter.php")
    fun getSingleMeal(
    @Query("c") c:String
    ): Call<SingleCategory>
}