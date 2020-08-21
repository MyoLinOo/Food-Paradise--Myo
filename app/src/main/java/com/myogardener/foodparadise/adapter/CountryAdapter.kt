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

class CountryAdapter(var meallist: List<com.myogardener.foodparadise.model.country.Meal> = ArrayList<Meal>()) :
    RecyclerView.Adapter<CountryAdapter.CountryViewHolder>() {

    var mClickListener: ClickListener? = null

    fun setOnClickListeners(clickListener: ClickListener){
        this.mClickListener = clickListener
    }

    inner class CountryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) ,View.OnClickListener{

        lateinit var meal: Meal

        init {
            itemView.setOnClickListener(this)
        }
        fun bind(meal:Meal) {

            this.meal = meal
            Log.d("meal", meal.strMeal)
            itemView.txt_country_meal.text = meal.strMeal

            Picasso.get()
                .load(meal.strMealThumb)
                .placeholder(R.drawable.ic_launcher_background)
                .into(itemView.img_country_meal)
        }

        override fun onClick(p0: View?) {
            mClickListener?.onClcik(meal)
        }

    }

    fun updateArticle(meallist: List<Meal>) {
        this.meallist = meallist
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_country, parent, false)
        return CountryViewHolder(view)
    }

    override fun getItemCount(): Int {
        return meallist.size
    }

    override fun onBindViewHolder(holder: CountryViewHolder, position: Int) {
        holder.bind(meallist.get(position))
    }

    interface ClickListener {
        fun onClcik(meal: Meal)
    }

}