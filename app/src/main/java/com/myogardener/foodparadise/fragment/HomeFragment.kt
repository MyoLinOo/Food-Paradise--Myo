package com.myogardener.foodparadise.fragment

import HomeAdapter
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.myogardener.foodparadise.R
import com.myogardener.foodparadise.model.home_model.Category
import com.myogardener.foodparadise.viewmodel.AllViewModel
import kotlinx.android.synthetic.main.fragment_alphabet.*
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.item_country.*
import java.util.*


class HomeFragment : Fragment() ,HomeAdapter.ClickListener{

    lateinit var allViewModel: AllViewModel
    lateinit var homeAdapter: HomeAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        super.onViewCreated(view, savedInstanceState)

        allViewModel = ViewModelProvider(this)
            .get(AllViewModel::class.java)

        homeAdapter = HomeAdapter()
        recyclerview_home.apply {
            layoutManager =GridLayoutManager(context,3)
            adapter = homeAdapter
        }

        homeAdapter.setOnClickListener(this)
        observeViewmodel()

        img_fist.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_alphabetFragment)
        }

        img_country.setOnClickListener{
            findNavController().navigate(R.id.action_homeFragment_to_countryFragment)
        }
        img_ingredien.setOnClickListener{
            findNavController().navigate(R.id.action_homeFragment_to_ingredientsFragment)
        }
    }

    private fun observeViewmodel() {
        allViewModel.getResult().observe(
            viewLifecycleOwner, Observer { categ ->
                homeAdapter.updateArticle(categ.categories)
            }
        )
}

override fun onResume() {
    super.onResume()
    allViewModel.loadCategory()
}

    override fun onClcik(category: Category) {
        var action= HomeFragmentDirections.actionHomeFragmentToCategoriesFragment(category.strCategory)
        findNavController().navigate(action)
    }


}

