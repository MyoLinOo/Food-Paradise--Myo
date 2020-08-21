package com.myogardener.foodparadise.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.myogardener.foodparadise.R
import com.myogardener.foodparadise.model.detail_model.Meal
import com.myogardener.foodparadise.model.home_model.Category
import com.myogardener.foodparadise.viewmodel.AllViewModel
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_detail.*
import kotlinx.android.synthetic.main.item_alphabet.view.*
import kotlinx.android.synthetic.main.item_home.view.*
import java.util.Observer

class AlphabetAdapter(var meallist: List<com.myogardener.foodparadise.model.alphabet.Meal> = ArrayList<com.myogardener.foodparadise.model.alphabet.Meal>()) :
    RecyclerView.Adapter<AlphabetAdapter.AlphabetViewHolder>() {

    var mClickListener: ClickListener? = null

    fun setOnClickListener(clickListener: ClickListener){
        this.mClickListener = clickListener
    }

    inner class AlphabetViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView),View.OnClickListener {

        lateinit var meal: com.myogardener.foodparadise.model.alphabet.Meal

        init {
            itemView.setOnClickListener(this)
        }

        fun bind(meal: com.myogardener.foodparadise.model.alphabet.Meal) {

            this.meal = meal
            Log.d("meal", meal.strCategory)
            itemView.txt_alphabet_meal.text = meal.strMeal

            Picasso.get()
                .load(meal.strMealThumb)
                .placeholder(R.drawable.ic_launcher_background)
                .into(itemView.img_alphabet_meal)
        }

        override fun onClick(p0: View?) {
            mClickListener?.onClcik(meal)
        }


//        override fun onClick(view: View?) {
//            mClickListener?.onClcik(category)
//
//        }
    }

    fun updateArticle(meallist: List<com.myogardener.foodparadise.model.alphabet.Meal>) {
        this.meallist = meallist
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AlphabetViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_alphabet, parent, false)
        return AlphabetViewHolder(view)
    }

    override fun getItemCount(): Int {
        return meallist.size
    }

    override fun onBindViewHolder(holder: AlphabetViewHolder, position: Int) {
        holder.bind(meallist.get(position))
    }

    interface ClickListener {
        fun onClcik(meal: com.myogardener.foodparadise.model.alphabet.Meal)
    }

}