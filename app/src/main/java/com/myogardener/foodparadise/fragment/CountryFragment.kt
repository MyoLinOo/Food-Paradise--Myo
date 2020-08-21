package com.myogardener.foodparadise.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.myogardener.foodparadise.R
import com.myogardener.foodparadise.adapter.AlphabetAdapter
import com.myogardener.foodparadise.adapter.CountryAdapter
import com.myogardener.foodparadise.model.country.Meal
import com.myogardener.foodparadise.viewmodel.AllViewModel
import kotlinx.android.synthetic.main.fragment_alphabet.*
import kotlinx.android.synthetic.main.fragment_country.*

class CountryFragment : Fragment() ,CountryAdapter.ClickListener{
    lateinit var countryAdapter: CountryAdapter
    lateinit var countryViewModel:AllViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_country, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var countries= listOf<String> ( "American","British","Canadian","Chinese","Dutch","Egyptian","French","Greek","Indian","Irish","Italian","Jamaican","Japanese","Kenyan","Malaysian","Mexican","Moroccan","Polish","Russian","Spanish","Thai","Tunisian","Turkish","Unknown","Vietnamese")
        var listCountry=
            context?.let { ArrayAdapter(it,android.R.layout.simple_spinner_dropdown_item,countries)  }
        myCountry_Spanner.adapter=listCountry

        countryViewModel = ViewModelProvider(this).get(AllViewModel::class.java)

        countryAdapter= CountryAdapter()
        recyclerview_country.apply {
            layoutManager = GridLayoutManager(context,2)
            adapter = countryAdapter
        }

        countryAdapter.setOnClickListeners(this)
////////

        myCountry_Spanner.onItemSelectedListener=object : AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(p0: AdapterView<*>?) {
            }

            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                onviewModel(countries[p2])
            }
        }
    }
    private fun onviewModel(countryName:String){

        countryViewModel.loadCountryMeal(countryName)
        countryViewModel.getResult5().observe(
            viewLifecycleOwner, Observer {meal->
                Log.d("meal",meal.toString())
                countryAdapter.updateArticle(meal.meals)
            }
        )
    }
    override fun onClcik(meal: Meal) {
        var action=CountryFragmentDirections.actionCountryFragmentToDetailFragment2(meal.idMeal)
        findNavController().navigate(action)
    }

}