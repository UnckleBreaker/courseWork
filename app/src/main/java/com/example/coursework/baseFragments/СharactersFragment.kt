package com.example.coursework.baseFragments

import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuInflater
import android.view.View
import android.widget.AbsListView
import androidx.appcompat.widget.SearchView
import androidx.core.view.MenuItemCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.coursework.dialogFilters.DialogFilterCharacters
import com.example.coursework.R
import com.example.coursework.adatpters.CharactersAdapter
import com.example.coursework.di.App
import com.example.coursework.listeners.CharacterClickListener
import com.example.coursework.listeners.dialog.DialogCharactersListener
import com.example.coursework.service.CheckState
import com.example.coursework.viewmodels.CharactersViewModel
import com.example.coursework.viewmodels.factories.CharactersViewModelFactory
import kotlinx.android.synthetic.main.fragment_characters.*
import kotlinx.android.synthetic.main.fragments_load_error.*
import javax.inject.Inject

class СharactersFragment : Fragment(R.layout.fragment_characters), DialogCharactersListener {

    @Inject
    lateinit var factory : CharactersViewModelFactory
    lateinit var vm: CharactersViewModel
    val itemAdapter: CharactersAdapter by lazy {
        CharactersAdapter(requireContext() as CharacterClickListener)
    }

    companion object {
        fun newInstance() = СharactersFragment()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        setHasOptionsMenu(true)
        activity?.actionBar?.setDisplayHomeAsUpEnabled(false)
        initRecycle()
        (requireContext().applicationContext as App).appComponent.inject(this)
        vm = ViewModelProvider(this, factory).get(CharactersViewModel::class.java)
        checkVisibility()
        vm.get(CheckState.isConnected(requireContext()))
        vm.data.observe(viewLifecycleOwner, Observer {
            itemAdapter.submitList(it.results)
            error_layout.visibility = View.INVISIBLE
        })
        vm.error.observe(viewLifecycleOwner, Observer {
            error_layout.visibility = View.VISIBLE
            error_text.text = it
        })
        swipeLayout_characters.setOnRefreshListener {
            vm.get(CheckState.isConnected(requireContext()))
            swipeLayout_characters.isRefreshing = false
        }
        float_filter.setOnClickListener {
            DialogFilterCharacters.newInstance(this)
                .show(parentFragmentManager, DialogFilterCharacters.dialog_filter_key)
        }
    }

    private fun initRecycle() {
        recycler.layoutManager =
            GridLayoutManager(requireContext(), 2, RecyclerView.VERTICAL, false)
        recycler.itemAnimator = null
        recycler.adapter = itemAdapter
    }

    fun checkVisibility() {
        vm.isLoading.observe(viewLifecycleOwner, Observer {
            if (it) progress_bar.visibility = View.VISIBLE
            else progress_bar.visibility = View.INVISIBLE
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
                if (newText != "" && newText != null) {
                    vm.findData(newText, CheckState.isConnected(requireContext()))
                } else vm.get(CheckState.isConnected(requireContext()))
                return true
            }
        })
    }

    override fun selected(status: String, spicies: String, gender: String, type: String) {
        vm.filterData(status, spicies, gender, type,CheckState.isConnected(requireContext()))
    }
}