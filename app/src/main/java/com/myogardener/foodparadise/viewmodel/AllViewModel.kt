package com.myogardener.foodparadise.viewmodel

import ApiClient
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.myogardener.foodparadise.model.alphabet.Alphabet
import com.myogardener.foodparadise.model.country.Country
import com.myogardener.foodparadise.model.detail_model.Detail
import com.myogardener.foodparadise.model.detail_model.Meal
import com.myogardener.foodparadise.model.home_model.Categories
import com.myogardener.foodparadise.model.ingredients.Ingredients
import com.myogardener.foodparadise.model.single_model.SingleCategory
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AllViewModel: ViewModel() {

    private var resultt: MutableLiveData<Categories> = MutableLiveData()
    fun getResult(): LiveData<Categories> = resultt
    fun loadCategory() {
        var apiClient = ApiClient()
        val call = apiClient.getCategories()

        call.enqueue(object: Callback<Categories> {
            override fun onFailure(call: Call<Categories>, t: Throwable) {
                Log.d("Error>>>>",t.toString())
            }
            override fun onResponse(call: Call<Categories>, response: Response<Categories>) {
                resultt.value = response.body()
            }
        })
    }


    private var result2: MutableLiveData<SingleCategory> = MutableLiveData()

    fun getResult2(): LiveData<SingleCategory> = result2

    fun loadSingleMeal(singleMeal:String){
        var apiClient = ApiClient()
        val call = apiClient.getSingleMealFun(singleMeal)

        call.enqueue(object: Callback<SingleCategory> {
            override fun onFailure(call: Call<SingleCategory>, t: Throwable) {
                Log.d("Error>>>>",t.toString())
            }
            override fun onResponse(call: Call<SingleCategory>, response: Response<SingleCategory>) {
                result2.value = response.body()
            }
        })
    }


    private var result3: MutableLiveData<Detail> = MutableLiveData()

    fun getResult3(): LiveData<Detail> = result3

    fun loadMealDetail(mealid:String){
        var apiClient = ApiClient()
        val call = apiClient.getMealIDFun(mealid)

        call.enqueue(object: Callback<Detail> {
            override fun onFailure(call: Call<Detail>, t: Throwable) {
                Log.d("Error>>>>",t.toString())
            }
            override fun onResponse(call: Call<Detail>, response: Response<Detail>) {
                result3.value = response.body()
            }
        })
    }

    private var result4: MutableLiveData<Alphabet> = MutableLiveData()

    fun getResult4(): LiveData<Alphabet> = result4

    fun loadAlphabetMeal(words:String){
        var apiClient = ApiClient()
        val call = apiClient.getAlphabetFun(words)

        call.enqueue(object: Callback<Alphabet> {
            override fun onFailure(call: Call<Alphabet>, t: Throwable) {
                Log.d("Error>>>>",t.toString())
            }
            override fun onResponse(call: Call<Alphabet>, response: Response<Alphabet>) {
                result4.value = response.body()
            }
        })
    }


    private var result5: MutableLiveData<Country> = MutableLiveData()

    fun getResult5(): LiveData<Country> = result5

    fun loadCountryMeal(countryName:String){
        var apiClient = ApiClient()
        val call = apiClient.getCountryFun(countryName)

        call.enqueue(object: Callback<Country> {
            override fun onFailure(call: Call<Country>, t: Throwable) {
                Log.d("Error>>>>",t.toString())
            }
            override fun onResponse(call: Call<Country>, response: Response<Country>) {
                result5.value = response.body()
            }
        })
    }


    private var result6: MutableLiveData<Ingredients> = MutableLiveData()

    fun getResult6(): LiveData<Ingredients> = result6

    fun loadIngredientMeal(ingredientName:String){
        var apiClient = ApiClient()
        val call = apiClient.getIngredientFun(ingredientName)

        call.enqueue(object: Callback<Ingredients> {
            override fun onFailure(call: Call<Ingredients>, t: Throwable) {
                Log.d("Error>>>>",t.toString())
            }
            override fun onResponse(call: Call<Ingredients>, response: Response<Ingredients>) {
                result6.value = response.body()
            }
        })
    }
}