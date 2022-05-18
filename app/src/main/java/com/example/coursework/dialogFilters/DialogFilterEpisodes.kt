package com.example.coursework.dialogFilters

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.example.coursework.R
import com.example.coursework.listeners.dialog.DialogEpisodesListener
import kotlinx.android.synthetic.main.dialog_filters_episodes.view.*

class DialogFilterEpisodes: DialogFragment(R.layout.dialog_filters_episodes) {

    companion object {
        const val dialog_filter_key = "DialogFilterEpisodesKey"
        fun newInstance(listener:DialogEpisodesListener) =
            DialogFilterEpisodes().also {
                it.arguments = Bundle().apply { putSerializable(dialog_filter_key, listener) }
            }
    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.dialog_filters_episodes,container,false)
        val item = requireArguments().getSerializable(dialog_filter_key) as DialogEpisodesListener
        view.btn_apply_episode.setOnClickListener {
            val name =view.textInputEpisName.text.toString()
            val episode = view.textInputEpisode.text.toString()
            item.selected(name = name,episode = episode)
            dismiss()
        }
        return view


    }
}