import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.myogardener.foodparadise.R
import com.myogardener.foodparadise.model.Category
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_home.view.*

class HomeAdapter(var categoryList: List<Category> = ArrayList<Category>()) :
    RecyclerView.Adapter<HomeAdapter.HomeViewHolder>() {

    var mClickListener: ClickListener? = null

    fun setOnClickListener(clickListener: ClickListener){
        this.mClickListener = clickListener
    }

    inner class HomeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView),View.OnClickListener {

        lateinit var category: Category

        init {
            itemView.setOnClickListener(this)
        }

        fun bind(category: Category) {
            this.category = category
            itemView.categories_name.text = category.strCategory

            Picasso.get()
                .load(category.strCategoryThumb)
                .placeholder(R.drawable.ic_launcher_background)
                .into(itemView.img_categories)
        }

        override fun onClick(view: View?) {
            mClickListener?.onClcik(category)
        }
    }

    fun updateArticle(categoryList: List<Category>) {
        this.categoryList = categoryList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_home, parent, false)
        return HomeViewHolder(view)
    }

    override fun getItemCount(): Int {
        return categoryList.size
    }

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
        holder.bind(categoryList.get(position))
    }

    interface ClickListener {
        fun onClcik(category: Category)
    }

}