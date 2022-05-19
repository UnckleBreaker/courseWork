package com.example.coursework.model.episode

import java.io.Serializable

data class ResultEpisode(
    val air_date: String,
    val characters: List<String>,
    val created: String,
    val episode: String,
    val id: Int,
    val name: String,
    val url: String
) : Serializable