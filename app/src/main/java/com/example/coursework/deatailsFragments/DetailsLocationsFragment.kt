package com.example.coursework.deatailsFragments

import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.coursework.R
import com.example.coursework.adatpters.CharactersAdapter
import com.example.coursework.listeners.CharacterClickListener
import com.example.coursework.listeners.LocationClickListener
import com.example.coursework.model.DetailsLocationFragmentArguments
import com.example.coursework.viewmodels.DetailsLocationsViewModel
import com.example.coursework.viewmodels.factories.DetailsLocationViewModelFactory
import kotlinx.android.synthetic.main.fragment_details_location.*

class DetailsLocationsFragment : Fragment(R.layout.fragment_details_location) {

    lateinit var vm: DetailsLocationsViewModel
    val charactersAdapter by lazy { CharactersAdapter(requireContext() as CharacterClickListener) }

    companion object {
        val DETAILS_LOCATIONS_FRAGMENT_TAG = "DETAILS_LOCATIONS_FRAGMENT_TAG"

        fun newInstance(item: DetailsLocationFragmentArguments): DetailsLocationsFragment {
            return DetailsLocationsFragment().also {
                it.arguments =
                    Bundle().apply { putSerializable(DETAILS_LOCATIONS_FRAGMENT_TAG, item) }
            }
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        activity?.actionBar?.setDisplayHomeAsUpEnabled(true)
        initRecycle()
        vm = ViewModelProvider(this, DetailsLocationViewModelFactory(requireContext())).get(
            DetailsLocationsViewModel::class.java
        )
        checkVisibility()
        showBundel()
        vm.dataList.observe(viewLifecycleOwner, Observer {
            charactersAdapter.submitList(it)
        })
    }

    private fun showBundel() {
        val argument =
            requireArguments().getSerializable(DETAILS_LOCATIONS_FRAGMENT_TAG) as DetailsLocationFragmentArguments
        if (argument.item == null) {
            vm.loadLocation(argument.url!!)

            vm.data.observe(viewLifecycleOwner, Observer {
                details_loc_demension.text = it.dimension
                details_loc_name.text = it.name
                details_loc_type.text = it.type
            })
        } else {
            vm.loadCharacters(argument.item.residents)
            details_loc_demension.text = argument.item.dimension
            details_loc_name.text = argument.item.name
            details_loc_type.text = argument.item.type
        }
    }

    private fun initRecycle() {
        details_loc_recyc.layoutManager =
            GridLayoutManager(requireContext(), 2, RecyclerView.VERTICAL, false)
        details_loc_recyc.adapter = charactersAdapter
    }

    fun checkVisibility() {
        vm.isLoading.observe(viewLifecycleOwner, Observer {
            if (it) progress_bar_loc_det.visibility = View.VISIBLE
            else progress_bar_loc_det.visibility = View.INVISIBLE
        })
    }
}