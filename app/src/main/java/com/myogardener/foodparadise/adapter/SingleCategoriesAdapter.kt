package com.myogardener.foodparadise.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.myogardener.foodparadise.R
import com.myogardener.foodparadise.model.single_model.Meal
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_category.view.*


class SingleCategoriesAdapter(var mealList: List<Meal> = ArrayList<Meal>()) :
    RecyclerView.Adapter<SingleCategoriesAdapter.HomeViewHolder>() {

    var mClickListener: ClickListener? = null

    fun setOnClickListener(clickListener: ClickListener){
        this.mClickListener = clickListener
    }

    inner class HomeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView),View.OnClickListener {

        lateinit var meal: Meal

        init {
            itemView.setOnClickListener(this)
        }

        fun bind(meal: Meal) {
            this.meal = meal
            itemView.txt_single_category.text = meal.strMeal

            Picasso.get()
                .load(meal.strMealThumb)
                .placeholder(R.drawable.ic_launcher_background)
                .into(itemView.img_single_category)
        }

        override fun onClick(view: View?) {
            mClickListener?.onClcik(meal)
        }
    }

    fun updateArticle(mealList: List<Meal>) {
        this.mealList = mealList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_category, parent, false)
        return HomeViewHolder(view)
    }

    override fun getItemCount(): Int {
        return mealList.size
    }

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
        holder.bind(mealList.get(position))
    }

    interface ClickListener {
        fun onClcik(meal:Meal)
    }

}