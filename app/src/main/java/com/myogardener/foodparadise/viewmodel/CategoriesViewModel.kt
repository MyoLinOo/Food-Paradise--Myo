package com.myogardener.foodparadise.viewmodel

import ApiClient
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.myogardener.foodparadise.model.Categories
import com.myogardener.foodparadise.model.SingleCategory
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CategoriesViewModel: ViewModel() {

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
}