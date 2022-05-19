package com.example.coursework.deatailsFragments

import android.graphics.BitmapFactory
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.coursework.R
import com.example.coursework.adatpters.DetailsEpisodeAdapter
import com.example.coursework.di.App
import com.example.coursework.listeners.EpisodeClickListener
import com.example.coursework.listeners.LocationClickListener
import com.example.coursework.listeners.LocationItemClickListener
import com.example.coursework.model.DetailsCharacterFragmentArguments
import com.example.coursework.model.character.ResultCharacter
import com.example.coursework.viewmodels.DetailsCharactersViewModel
import com.example.coursework.viewmodels.factories.DetailsCharacterViewModelFactory
import kotlinx.android.synthetic.main.fragment_details_character.*
import javax.inject.Inject

class DetailsCharactersFragment : Fragment(R.layout.fragment_details_character) {

    @Inject
    lateinit var factory: DetailsCharacterViewModelFactory
    lateinit var vm: DetailsCharactersViewModel
    val adapter: DetailsEpisodeAdapter by lazy {
        DetailsEpisodeAdapter(requireContext() as EpisodeClickListener)
    }

    companion object {
        const val DETAILS_FRAGMENT_TAG = "DETAILS_FRAGMENT_TAG"
        fun newInstance(model: DetailsCharacterFragmentArguments) =
            DetailsCharactersFragment().also {
                it.arguments = Bundle().apply { putSerializable(DETAILS_FRAGMENT_TAG, model) }
            }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        activity?.actionBar?.setDisplayHomeAsUpEnabled(true)
        initRecycle()
        (requireContext().applicationContext as App).appComponent.inject(this)
        vm = ViewModelProvider(this, factory).get(DetailsCharactersViewModel::class.java)
        checkVisibility()
        showBundel()
        vm.data.observe(viewLifecycleOwner, {
            adapter.submitList(it)
        })
    }

    private fun showBundel() {
        val item = requireArguments().getSerializable(DETAILS_FRAGMENT_TAG) as DetailsCharacterFragmentArguments
        vm.loadEpisodes(item.model.episode)

        details_char_name.text = item.model.name
        details_char_gender.text = item.model.gender
        details_char_species.text = item.model.species
        details_char_location.text = item.model.location.name
        details_char_origin.text = item.model.origin.name
        deatils_char_image.setImageBitmap(BitmapFactory.decodeFile(item.model.image.path))

        details_char_location.setOnClickListener { item.listener.onLocationClick(item.model.location.url) }
        details_char_origin.setOnClickListener { item.listener.onLocationClick(item.model.origin.url) }
    }

    private fun initRecycle() {
        details_char_recyc.layoutManager =
            LinearLayoutManager(requireContext(), RecyclerView.VERTICAL, false)
        details_char_recyc.itemAnimator = null
        details_char_recyc.adapter = adapter
    }

    fun checkVisibility() {
        vm.isLoading.observe(viewLifecycleOwner, Observer {
            if (it) progress_bar_char_det.visibility = View.VISIBLE
            else progress_bar_char_det.visibility = View.INVISIBLE
        })
    }
}