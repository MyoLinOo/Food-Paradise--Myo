package com.myogardener.foodparadise.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.myogardener.foodparadise.R
import com.myogardener.foodparadise.model.country.Meal
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_country.view.*
import kotlinx.android.synthetic.main.item_ingredients.view.*

class IngredientsAdapter(var meallist: List<com.myogardener.foodparadise.model.ingredients.Meal> = ArrayList<com.myogardener.foodparadise.model.ingredients.Meal>()) :
    RecyclerView.Adapter<IngredientsAdapter.IngredientsViewHolder>() {

    var mClickListener: ClickListener? = null

    fun setOnClickListeners(clickListener: ClickListener){
        this.mClickListener = clickListener
    }

    inner class IngredientsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) , View.OnClickListener{

        lateinit var meal: com.myogardener.foodparadise.model.ingredients.Meal

        init {
            itemView.setOnClickListener(this)
        }
        fun bind(meal: com.myogardener.foodparadise.model.ingredients.Meal) {

            this.meal = meal
            Log.d("meal", meal.strMeal)
            itemView.txt_ingredients_meal.text = meal.strMeal

            Picasso.get()
                .load(meal.strMealThumb)
                .placeholder(R.drawable.ic_launcher_background)
                .into(itemView.img_ingredients_meal)
        }

        override fun onClick(p0: View?) {
            mClickListener?.onClcik(meal)
        }

    }

    fun updateArticle(meallist: List<com.myogardener.foodparadise.model.ingredients.Meal>) {
        this.meallist = meallist
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): IngredientsViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_ingredients, parent, false)
        return IngredientsViewHolder(view)
    }

    override fun getItemCount(): Int {
        return meallist.size
    }

    override fun onBindViewHolder(holder: IngredientsViewHolder, position: Int) {
        holder.bind(meallist.get(position))
    }

    interface ClickListener {
        fun onClcik(meal: com.myogardener.foodparadise.model.ingredients.Meal)
    }

}