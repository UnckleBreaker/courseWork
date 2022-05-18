package com.example.coursework.dialogFilters

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.children
import androidx.fragment.app.DialogFragment
import com.example.coursework.R
import com.example.coursework.listeners.dialog.DialogCharactersListener
import com.google.android.material.chip.Chip
import kotlinx.android.synthetic.main.dialog_filter_cahracters.*
import kotlinx.android.synthetic.main.dialog_filter_cahracters.view.*

class DialogFilterCharacters : DialogFragment() {

    companion object {
        const val dialog_filter_key = "DialogFilterKey"
        fun newInstance(listener: DialogCharactersListener) =
            DialogFilterCharacters().also {
                it.arguments = Bundle().apply { putSerializable(dialog_filter_key, listener) }
            }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.dialog_filter_cahracters,container,false)
        val item = requireArguments().getSerializable(dialog_filter_key) as DialogCharactersListener
        var status = ""
        var gender = ""
        view.btn_apply.setOnClickListener {
            if((view.group_chip.children.toList().filter {  (it as Chip).isChecked }).count()>0){
                 status = view.group_chip.findViewById<Chip>(group_chip.checkedChipId).text.toString()
            }
            if((view.group_chip_gender.children.toList().filter {  (it as Chip).isChecked }).count()>0){
                 gender = view.group_chip_gender.findViewById<Chip>(group_chip_gender.checkedChipId).text.toString()
            }
            val species =view.textInputSpecies.text.toString()
            val type = view.textInputType.text.toString()
            item.selected(status = status, gender = gender, spicies = species,type = type)

            dismiss()
        }
       return view


    }
}