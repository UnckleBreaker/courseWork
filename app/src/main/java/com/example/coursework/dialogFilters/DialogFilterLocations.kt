package com.example.coursework.dialogFilters

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.children
import androidx.fragment.app.DialogFragment
import com.example.coursework.R
import com.example.coursework.listeners.dialog.DialogLocationsListener
import kotlinx.android.synthetic.main.dialog_filter_locations.view.*

class DialogFilterLocations :DialogFragment() {

    companion object {
        const val dialog_filter_key = "dialog_filter_location_Key"
        fun newInstance(listener: DialogLocationsListener) =
            DialogFilterLocations().also {
                it.arguments = Bundle().apply { putSerializable(dialog_filter_key, listener) }
            }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.dialog_filter_locations,container,false)
        val item = requireArguments().getSerializable(dialog_filter_key) as DialogLocationsListener
        view.btn_apply_loc.setOnClickListener {
            val name =view.textInputLocName.text.toString()
            val type = view.textInputLocType.text.toString()
            val demension = view.textInputlocDimension.text.toString()
            item.selected(name, type, demension)

            dismiss()
        }
        return view


    }
}