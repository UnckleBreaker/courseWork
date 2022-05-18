package com.example.coursework.baseFragments

import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuInflater
import android.view.View
import androidx.appcompat.widget.SearchView
import androidx.core.view.MenuItemCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.coursework.R
import com.example.coursework.adatpters.LocationAdapter
import com.example.coursework.listeners.LocationItemClickListener
import com.example.coursework.viewmodels.LocationsViewModel
import com.example.coursework.viewmodels.factories.LocationsViewModelFactory
import kotlinx.android.synthetic.main.fragment_episodes.*
import kotlinx.android.synthetic.main.fragment_locations.*
import kotlinx.android.synthetic.main.fragments_load_error.*

class LocationFragment : Fragment(R.layout.fragment_locations) {

    lateinit var vm: LocationsViewModel
    val itemAdapter: LocationAdapter by lazy {
        LocationAdapter(requireContext() as LocationItemClickListener)
    }

    companion object {
        fun newInstance() = LocationFragment()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        activity?.actionBar?.setDisplayHomeAsUpEnabled(false)
        setHasOptionsMenu(true)
        initRecycle()
        super.onViewCreated(view, savedInstanceState)
        vm = ViewModelProvider(this, LocationsViewModelFactory(requireContext())).get(
            LocationsViewModel::class.java
        )
        checkVisibility()
        vm.get(requireContext())
        vm.data.observe(viewLifecycleOwner, Observer {
            itemAdapter.submitList(it.results)
            error_layout_locations.visibility=View.INVISIBLE
        })
        vm.error.observe(viewLifecycleOwner, Observer {
            error_layout_locations.visibility=View.VISIBLE
            error_text.text =it
        })

        swipeLayout_locations.setOnRefreshListener {
            vm.get(requireContext())
            swipeLayout_locations.isRefreshing = false
        }
    }

    private fun initRecycle() {
        recycler_locations.layoutManager =
            GridLayoutManager(requireContext(), 2, RecyclerView.VERTICAL, false)
        recycler_locations.itemAnimator = null
        recycler_locations.adapter = itemAdapter
    }

    fun checkVisibility() {
        vm.isLoading.observe(viewLifecycleOwner, Observer {
            if (it) progress_bar_location.visibility = View.VISIBLE
            else progress_bar_location.visibility = View.INVISIBLE
        })
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_search, menu)
        val item = menu.findItem(R.id.search_view)
        super.onCreateOptionsMenu(menu, inflater)
        val searchView = MenuItemCompat.getActionView(item) as SearchView
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean = false

            override fun onQueryTextChange(newText: String?): Boolean {
                if (newText != null && newText != "")
                    vm.filterData(newText,requireContext())
                else vm.get(requireContext())
                return true
            }
        })
    }


}