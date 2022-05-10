package com.example.coursework.baseFragments

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.Observer
import com.example.coursework.R
import com.example.coursework.viewmodels.EpisodeViewModel
import com.example.coursework.viewmodels.factories.EpisodesViewModelFactory

class EpisodesFragment : Fragment(R.layout.fragment_episodes) {

    lateinit var vm : EpisodeViewModel
    companion object{
        fun newInstance() = EpisodesFragment()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        vm = ViewModelProvider(this, EpisodesViewModelFactory(requireContext())).get(
            EpisodeViewModel::class.java)
        vm.get()
        vm.data.observe(viewLifecycleOwner, Observer {
            Toast.makeText(requireContext(),"$it", Toast.LENGTH_LONG).show()
 //           itemAdapter.submitList(it.results)
        })
    }
}