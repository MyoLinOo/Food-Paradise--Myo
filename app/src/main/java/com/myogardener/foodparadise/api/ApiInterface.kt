package com.myogardener.foodparadise.api

import com.myogardener.foodparadise.model.alphabet.Alphabet
import com.myogardener.foodparadise.model.country.Country
import com.myogardener.foodparadise.model.detail_model.Detail
import com.myogardener.foodparadise.model.detail_model.Meal
import com.myogardener.foodparadise.model.home_model.Categories
import com.myogardener.foodparadise.model.ingredients.Ingredients
import com.myogardener.foodparadise.model.single_model.SingleCategory
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

    @GET("lookup.php")
    fun getMealID(
        @Query("i") id:String
    ): Call<Detail>


    @GET("search.php")
    fun getAlphabetMeal(
        @Query("f") words:String
    ): Call<Alphabet>

    @GET("filter.php")
    fun getCountry(
        @Query("a") countryName:String
    ): Call<Country>

    @GET("filter.php")
    fun getIngredients(
        @Query("i") ingredientName:String
    ):Call<Ingredients>
}