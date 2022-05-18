package com.example.data.db.entity.episode

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "entity_episode_result")
data class EntityEpisode(
    val air_date: String,
    val characters: List<String>,
    val created: String,
    val episode: String,
    @PrimaryKey
    val id: Int,
    val name: String,
    val url: String
)