package com.myogardener.foodparadise.fragment

import android.content.DialogInterface
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.myogardener.foodparadise.R
import com.myogardener.foodparadise.adapter.AlphabetAdapter
import com.myogardener.foodparadise.model.alphabet.Meal
import com.myogardener.foodparadise.model.home_model.Category
import com.myogardener.foodparadise.viewmodel.AllViewModel
import kotlinx.android.synthetic.main.fragment_alphabet.*
import java.lang.StringBuilder


class AlphabetFragment : Fragment() ,AlphabetAdapter.ClickListener{

    lateinit var alphabetViewModel: AllViewModel
    lateinit var alphabetAdapter: AlphabetAdapter
    private lateinit var alphabet :String

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_alphabet, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var fruids= listOf<String> ( "A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z")
        var arrayAlphabet=
            context?.let {ArrayAdapter(it,android.R.layout.simple_spinner_dropdown_item,fruids)  }
        myAlphabet_spinner.adapter=arrayAlphabet

        alphabetViewModel = ViewModelProvider(this).get(AllViewModel::class.java)

        alphabetAdapter = AlphabetAdapter()
        recyclerview_alphabet.apply {
            layoutManager = GridLayoutManager(context,2)
            adapter = alphabetAdapter
        }

        alphabetAdapter.setOnClickListener(this)
////////

 myAlphabet_spinner.onItemSelectedListener=object : AdapterView.OnItemSelectedListener{
     override fun onNothingSelected(p0: AdapterView<*>?) {

     }

     override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
         onviewModel(fruids[p2])
     }

 }

        }
    private fun onviewModel(word:String){

        alphabetViewModel.loadAlphabetMeal(word)
        alphabetViewModel.getResult4().observe(
            viewLifecycleOwner, Observer {meal->
                Log.d("meal",meal.toString())
                alphabetAdapter.updateArticle(meal.meals)
            }
        )
    }
    override fun onClcik(meal: Meal) {
var action=AlphabetFragmentDirections.actionAlphabetFragmentToDetailFragment2(meal.idMeal)
        findNavController().navigate(action)
    }

}
