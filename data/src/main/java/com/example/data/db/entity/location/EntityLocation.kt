package com.example.data.db.entity.location

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "entity_location_result")
data class EntityLocation(
    val created: String,
    val dimension: String,
    @PrimaryKey
    val id: Int,
    val name: String,
    val residents: List<String>,
    val type: String,
    val url: String
)