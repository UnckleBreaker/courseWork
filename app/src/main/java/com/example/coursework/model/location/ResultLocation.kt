package com.example.coursework.model.location

import java.io.Serializable

data class ResultLocation(
    val created: String,
    val dimension: String,
    val id: Int,
    val name: String,
    val residents: List<String>,
    val type: String,
    val url: String
):Serializable