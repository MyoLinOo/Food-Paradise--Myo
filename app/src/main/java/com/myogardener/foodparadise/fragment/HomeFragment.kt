package com.myogardener.foodparadise.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.myogardener.foodparadise.R
import com.myogardener.foodparadise.adapter.HomeAdapter
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment() {

    lateinit var homeAdapter: HomeAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        moviesViewModel = ViewModelProvider(this)
//            .get(ViewModel::class.java)

        homeAdapter=HomeAdapter()
        recyclerview_home.apply {
            layoutManager = GridLayoutManager(context,3)
            adapter = homeAdapter
        }
 //       homeAdapter.setOnClickListener(this)
//        observeViewmodel()
    }
//    private fun observeViewmodel() {
//        moviesViewModel.loadNews()
//        moviesViewModel.getResult().observe(
//            viewLifecycleOwner, Observer {movie->
//                moviesAdapter.updateArticle(movie.results)
//            }
//        )
//    }

//    override fun onResume() {
//        super.onResume()
//        moviesViewModel.loadNews()
//    }

}