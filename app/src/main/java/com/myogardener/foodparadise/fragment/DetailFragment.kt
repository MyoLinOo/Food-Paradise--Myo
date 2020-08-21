package com.myogardener.foodparadise.fragment

import android.app.AlertDialog
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.myogardener.foodparadise.R
import com.myogardener.foodparadise.viewmodel.AllViewModel
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_detail.*


class DetailFragment : Fragment() {
    lateinit var detailviewModel: AllViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        detailviewModel = ViewModelProvider(this)
            .get(AllViewModel::class.java)
        var messageArgs = arguments?.let {
            DetailFragmentArgs.fromBundle(it)
        }
        var id: String = messageArgs!!.id.toString()

        onviewModel(id)
    }

    private fun onviewModel(mealid: String) {

        detailviewModel.loadMealDetail(mealid)
        detailviewModel.getResult3().observe(
            viewLifecycleOwner, Observer { meal ->

                Log.d("moviedetail", meal.toString())
                var meal = meal.meals
                detail_title.text = meal[0].strMeal
                detail_country.text = meal[0].strArea
                detail_meal.text = meal[0].strCategory
                txt_instructions.text = meal[0].strInstructions

                Picasso.get()
                    .load(meal[0].strMealThumb)
                    .placeholder(R.drawable.ic_launcher_background)
                    .into(detail_img)

                youtube.setOnClickListener {
                    startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(meal[0].strYoutube)))
                }
                detail_ingredent.setOnClickListener {
                    var builder = AlertDialog.Builder(context)
                    builder.setTitle(meal[0].strMeal)

                    builder.setMessage(

                                meal[0].strCategory +
                                "\n" + meal[0].strIngredient1 + " = " + meal[0].strMeasure1 +
                                "\n" + meal[0].strIngredient2 + " = " + meal[0].strMeasure2 +
                                "\n" + meal[0].strIngredient3 + " = " + meal[0].strMeasure3 +
                                "\n" + meal[0].strIngredient4 + " = " + meal[0].strMeasure4 +
                                "\n" + meal[0].strIngredient5 + " = " + meal[0].strMeasure5 +
                                "\n" + meal[0].strIngredient6 + " = " + meal[0].strMeasure6 +
                                "\n" + meal[0].strIngredient7 + " = " + meal[0].strMeasure7 +
                                "\n" + meal[0].strIngredient8 + " = " + meal[0].strMeasure8 +
                                "\n" + meal[0].strIngredient9 + " = " + meal[0].strMeasure9
                    )
                  val alertDialog: AlertDialog = builder.create()
                    alertDialog.show()
                }
            }
        )
    }

}