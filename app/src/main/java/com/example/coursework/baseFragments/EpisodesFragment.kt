package com.example.coursework.baseFragments

import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuInflater
import android.view.View
import android.widget.Toast
import androidx.appcompat.widget.SearchView
import androidx.core.view.MenuItemCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.coursework.R
import com.example.coursework.adatpters.EpisodeAdapter
import com.example.coursework.listeners.EpisodeClickListener
import com.example.coursework.viewmodels.EpisodeViewModel
import com.example.coursework.viewmodels.factories.EpisodesViewModelFactory
import kotlinx.android.synthetic.main.fragment_characters.*
import kotlinx.android.synthetic.main.fragment_episodes.*
import kotlinx.android.synthetic.main.fragment_locations.*
import kotlinx.android.synthetic.main.fragments_load_error.*

class EpisodesFragment : Fragment(R.layout.fragment_episodes) {

    lateinit var vm : EpisodeViewModel
    val itemAdapter: EpisodeAdapter by lazy {
        EpisodeAdapter(requireContext() as EpisodeClickListener)
    }
    companion object{
        fun newInstance() = EpisodesFragment()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        activity?.actionBar?.setDisplayHomeAsUpEnabled(false)
        setHasOptionsMenu(true)
        initRecycle()
        vm = ViewModelProvider(this, EpisodesViewModelFactory(requireContext())).get(
            EpisodeViewModel::class.java)
        checkVisibility()
        vm.get(requireContext())
        vm.data.observe(viewLifecycleOwner, Observer {
            itemAdapter.submitList(it.results)
            error_layout_episode.visibility=View.INVISIBLE
        })
        vm.error.observe(viewLifecycleOwner, Observer {
            error_layout_episode.visibility=View.VISIBLE
            error_text.text =it
        })

        swipeLayout_episode.setOnRefreshListener {
            vm.get(requireContext())
            swipeLayout_episode.isRefreshing = false
        }
    }
    private fun initRecycle() {
        recycler_episodes.layoutManager =  GridLayoutManager(requireContext(),2, RecyclerView.VERTICAL,false)
        recycler_episodes.itemAnimator = null
        recycler_episodes.adapter = itemAdapter
    }
    fun checkVisibility(){
        vm.isLoading.observe(viewLifecycleOwner,Observer{
            if(it) progress_bar_episode.visibility=View.VISIBLE
            else progress_bar_episode.visibility=View.INVISIBLE
        })
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_search, menu)
        val item =menu.findItem(R.id.search_view)
        super.onCreateOptionsMenu(menu, inflater)
        val searchView = MenuItemCompat.getActionView(item) as SearchView
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean= false

            override fun onQueryTextChange(newText: String?): Boolean {
                if(newText!=null && newText != "")
                    vm.filterData(newText)
                else vm.get(requireContext())
                return false
            }
        })
    }
}