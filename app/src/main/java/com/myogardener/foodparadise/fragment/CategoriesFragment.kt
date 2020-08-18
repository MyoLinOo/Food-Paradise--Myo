package com.myogardener.foodparadise.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.myogardener.foodparadise.R
import com.myogardener.foodparadise.adapter.SingleCategoriesAdapter
import com.myogardener.foodparadise.viewmodel.CategoriesViewModel
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_categories.*
import kotlinx.android.synthetic.main.item_category.*


class CategoriesFragment : Fragment() {
     lateinit var singleMealViewModel:CategoriesViewModel
    lateinit var singleAdapter:SingleCategoriesAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_categories, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        singleMealViewModel = ViewModelProvider(this)
            .get(CategoriesViewModel::class.java)

        singleAdapter = SingleCategoriesAdapter()
        recyclerview_categories.apply {
            layoutManager = GridLayoutManager(context,2)
            adapter = singleAdapter
        }
        singleMealViewModel = ViewModelProvider(this).get(CategoriesViewModel::class.java)
        var messageArgs = arguments?.let {
            CategoriesFragmentArgs.fromBundle(it)
        }
        var meal:String=messageArgs!!.meal
        Log.d("meal",meal)
        onviewModel(meal)

    }
    private fun onviewModel(singleMeal:String){


        singleMealViewModel.loadSingleMeal(singleMeal)
        singleMealViewModel.getResult2().observe(
            viewLifecycleOwner, Observer {meal->
                Log.d("meal",meal.toString())
            singleAdapter.updateArticle(meal.meals)
            }
        )
    }
}