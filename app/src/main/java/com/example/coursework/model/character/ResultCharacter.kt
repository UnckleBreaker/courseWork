package com.example.coursework.model.character

import java.io.File
import java.io.Serializable

data class ResultCharacter(
    val created: String,
    val episode: List<String>,
    val gender: String,
    val id: Int,
    val image: File,
    val location: Location,
    val name: String,
    val origin: Origin,
    val species: String,
    val status: String,
    val url: String
) :Serializable