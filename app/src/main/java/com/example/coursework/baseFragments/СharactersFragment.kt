package com.example.coursework.baseFragments

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.coursework.R
import com.example.coursework.adatpters.CharactersAdapter
import com.example.coursework.viewmodels.CharactersViewModel
import com.example.coursework.viewmodels.factories.CharactersViewModelFactory
import kotlinx.android.synthetic.main.fragment_characters.*

class СharactersFragment : Fragment(R.layout.fragment_characters) {

    lateinit var vm :CharactersViewModel
    val itemAdapter: CharactersAdapter by lazy {
        CharactersAdapter()
    }

    companion object{
        fun newInstance()= СharactersFragment()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        initRecycle()
        vm = ViewModelProvider(this, CharactersViewModelFactory(requireContext())).get(CharactersViewModel::class.java)
        vm.get()
        vm.data.observe(viewLifecycleOwner, Observer {
            itemAdapter.submitList(it.results)
        })

    }

    private fun initRecycle() {
        recycler.layoutManager = LinearLayoutManager(requireContext())
        recycler.itemAnimator = null
        recycler.adapter = itemAdapter
    }
}