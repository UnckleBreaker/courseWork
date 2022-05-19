package com.example.data.db.entity.character

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.File

@Entity(tableName = "entity_character_result")
data class EntityCharacter(
    val created: String,
    val episode: List<String>,
    val gender: String,
    @PrimaryKey
    val id:Int,
    val image: File,
    val location: Location,
    val name: String,
    val origin: Origin,
    val species: String,
    val status: String,
    val type: String,
    val url: String
)