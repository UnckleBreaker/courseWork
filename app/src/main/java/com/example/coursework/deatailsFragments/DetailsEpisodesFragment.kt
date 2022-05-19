package com.example.coursework.deatailsFragments

import android.os.Bundle
import android.util.Log
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
import com.example.coursework.di.App
import com.example.coursework.listeners.CharacterClickListener
import com.example.coursework.model.episode.ResultEpisode
import com.example.coursework.viewmodels.DetailsCharactersViewModel
import com.example.coursework.viewmodels.DetailsEpisodesViewModel
import com.example.coursework.viewmodels.factories.DetailsCharacterViewModelFactory
import com.example.coursework.viewmodels.factories.DetailsEpisodesViewModelFactory
import kotlinx.android.synthetic.main.fragment_details_character.*
import kotlinx.android.synthetic.main.fragment_details_episode.*
import javax.inject.Inject

class DetailsEpisodesFragment : Fragment(R.layout.fragment_details_episode) {
    @Inject
    lateinit var factory : DetailsEpisodesViewModelFactory
    lateinit var vm: DetailsEpisodesViewModel
    val adapter: CharactersAdapter by lazy {
        CharactersAdapter(requireContext() as CharacterClickListener)
    }

    companion object {
        val DETAILS_EPISODE_FRAGMENT_TAG = "DETAILS_EPISODE_FRAGMENT_TAG"
        fun newInstance(item: ResultEpisode) = DetailsEpisodesFragment().also {
            it.arguments = Bundle().apply { putSerializable(DETAILS_EPISODE_FRAGMENT_TAG, item) }
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        activity?.actionBar?.setDisplayHomeAsUpEnabled(true)
        (requireContext().applicationContext as App).appComponent.inject(this)
        vm = ViewModelProvider(this, factory).get(DetailsEpisodesViewModel::class.java)
        checkVisibility()
        initRecycle()
        showBundel()
        vm.data.observe(viewLifecycleOwner, Observer {
            adapter.submitList(it)
        })
    }

    private fun showBundel() {
        val item = requireArguments().getSerializable(DETAILS_EPISODE_FRAGMENT_TAG) as ResultEpisode
        vm.loadEpisodes(item.characters)
        details_epis_name.text = item.name
        details_epis_air_date.text = item.air_date
        details_epis_number.text = item.episode
    }

    private fun initRecycle() {
        details_epis_recyc.layoutManager =
            GridLayoutManager(requireContext(), 2, RecyclerView.VERTICAL, false)
        details_epis_recyc.adapter = adapter
    }

    fun checkVisibility() {
        vm.isLoading.observe(viewLifecycleOwner, Observer {
            if (it) progress_bar_epis_det.visibility = View.VISIBLE
            else progress_bar_epis_det.visibility = View.INVISIBLE
        })
    }
}