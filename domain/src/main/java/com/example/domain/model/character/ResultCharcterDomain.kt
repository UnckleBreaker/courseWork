package com.example.domain.model.character

import java.io.File

data class ResultCharcterDomain(
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
    val type: String,
    val url: String
)