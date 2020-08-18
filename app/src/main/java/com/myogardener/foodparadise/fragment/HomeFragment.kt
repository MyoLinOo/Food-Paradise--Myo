package com.myogardener.foodparadise.fragment

import HomeAdapter
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.myogardener.foodparadise.R
import com.myogardener.foodparadise.model.Category
import com.myogardener.foodparadise.viewmodel.CategoriesViewModel
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment() ,HomeAdapter.ClickListener{

    lateinit var categoriesViewModel: CategoriesViewModel
    lateinit var homeAdapter: HomeAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        super.onViewCreated(view, savedInstanceState)

        categoriesViewModel = ViewModelProvider(this)
            .get(CategoriesViewModel::class.java)

        homeAdapter = HomeAdapter()
        recyclerview_home.apply {
            layoutManager =GridLayoutManager(context,3)
            adapter = homeAdapter
        }
        homeAdapter.setOnClickListener(this)
        observeViewmodel()
    }

    private fun observeViewmodel() {
        categoriesViewModel.getResult().observe(
            viewLifecycleOwner, Observer { categ ->
                homeAdapter.updateArticle(categ.categories)
            }
        )
}

override fun onResume() {
    super.onResume()
    categoriesViewModel.loadCategory()
}

    override fun onClcik(category: Category) {
var action= HomeFragmentDirections.actionHomeFragmentToCategoriesFragment(category.strCategory)
        findNavController().navigate(action)
    }


}

