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
import com.myogardener.foodparadise.adapter.CountryAdapter
import com.myogardener.foodparadise.adapter.IngredientsAdapter
import com.myogardener.foodparadise.model.ingredients.Meal
import com.myogardener.foodparadise.viewmodel.AllViewModel
import kotlinx.android.synthetic.main.fragment_country.*
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.fragment_ingredients.*

class IngredientsFragment : Fragment(), IngredientsAdapter.ClickListener {

    lateinit var ingredientsAdapter: IngredientsAdapter
    lateinit var ingredentsViewModel: AllViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_ingredients, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var ingredents = listOf<String>(
            "Chicken",
            "Salmon",
            "Beef",
            "Pork",
            "Avocado",
            "Apple Cider Vinegar",
            "Asparagus",
            "Aubergine",
            "Baby Plum Tomatoes",
            "Bacon",
            "Baking Powder",
            "Basil",
            "Basil Leaves",
            "Basmati Rice",
            "Bay Leaf",
            "Bay Leaves",
            "Beef Brisket",
            "Beef Fillet",
            "Beef Gravy",
            "Beef Stock",
            "Bicarbonate Of Soda",
            "Biryani Masala",
            "Black Pepper",
            "Black Treacle",
            "Borlottic Beans",
            "Bowtie Pasta",
            "Bramley Apples",
            "Brandy",
            "Bread",
            "Breadcrumbs",
            "Broccoli",
            "Brown Lentils",
            "Brown Sugar",
            "Butter",
            "Cacao",
            "Cajun",
            "Canned Tomatoes",
            "Cannellini Beans",
            "Cardamom",
            "Carrots",
            "Cashew Nuts",
            "Caster Sugar",
            "Celery Pepper",
            "Celeriac",
            "Celery Salt",
            "Cheese",
            "Chilli",
            "Chopped Onion",
            "Tomatoes",
            "Cold Water",
            "Milk",
            "Dill",
            "Doner Meat",
            "Eggs",
            "Flour",
            "Potatoes",
            "Hot Beef Stock",
            "Hotsauce",
            "Ice Cream",
            "Italian Fennel Sausages",
            "Jasmine Rice",
            "Kale",
            "Lamb",
            "Leek",
            "Lemon",
            "Lemons",
            "Lime",
            "Macaroni",
            "Marjoram",
            "Meringue Nests",
            "Mint",
            "Mushrooms",
            "Mustard",
            "Mustard Seeds",
            "Nutmeg",
            "Oil",
            "Olive Oil",
            "Onion Salt",
            "Onions",
            "Orange",
            "Paprika",
            "Parmesan",
            "Parsley",
            "Peanuts",
            "Peas",
            "Pecorino",
            "Pepper",
            "Pine Nuts",
            "Rice",
            "Rigatoni",
            "Rocket",
            "Sage",
            "Sake",
            "Salsa",
            "Salt",
            "Sausages",
            "Shallots",
            "Spaghetti",
            "Sugar",
            "Sultanas",
            "Thyme",
            "Tomatoes",
            "Toor Dal",
            "Tuna",
            "turmeric",
            "Veal",
            "Vegan Butter",
            "Vinegar",
            "Fish",
            "Yogurt",
            "Zucchini",
            "Pertzels",
            "Cream Cheese",
            "Duck",
            "Clams",
            "Passata",
            "Goose Fat",
            "Sweetcorn",
            "Banana",
            "Mascarpone",
            "Ricotta",
            "Dried Apricots",
            "Capers",
            "Blueberries",
            "Walnuts",
            "Pecan Nuts",
            "Pumpkin",
            "Peaches",
            "Jam",
            "Herring",
            "Shortening",
            "Buns",
            "Quinoa"

        )
        var listIngredent =
            context?.let {
                ArrayAdapter(
                    it,
                    android.R.layout.simple_spinner_dropdown_item,
                    ingredents
                )
            }
        my_ingredients_Spanner.adapter = listIngredent

        ingredentsViewModel = ViewModelProvider(this).get(AllViewModel::class.java)

        ingredientsAdapter = IngredientsAdapter()
        recyclerview_ingredients.apply {
            layoutManager = GridLayoutManager(context, 2)
            adapter = ingredientsAdapter
        }

        ingredientsAdapter.setOnClickListeners(this)
////////

        my_ingredients_Spanner.onItemSelectedListener =
            object : AdapterView.OnItemSelectedListener {
                override fun onNothingSelected(p0: AdapterView<*>?) {
                }

                override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                    onviewModel(ingredents[p2])
                }
            }

    }

    private fun onviewModel(ingredientsName: String) {

        ingredentsViewModel.loadIngredientMeal(ingredientsName)
        ingredentsViewModel.getResult6().observe(
            viewLifecycleOwner, Observer { meal ->
                Log.d("meal", meal.toString())
                ingredientsAdapter.updateArticle(meal.meals)
            }
        )
    }

    override fun onClcik(meal: Meal) {
        var action =
            IngredientsFragmentDirections.actionIngredientsFragmentToDetailFragment2(meal.idMeal)
        findNavController().navigate(action)
    }
}


