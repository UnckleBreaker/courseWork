package com.example.coursework.model

import com.example.coursework.listeners.LocationClickListener
import com.example.coursework.model.location.ResultLocation
import java.io.Serializable

data class DetailsLocationFragmentArguments(
    val url: String?,
    val item: ResultLocation?
) : Serializable
