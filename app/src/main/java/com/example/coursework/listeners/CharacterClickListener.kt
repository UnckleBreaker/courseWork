package com.example.coursework.listeners

import com.example.coursework.model.character.ResultCharacter
import com.example.coursework.model.episode.ResultEpisode
import com.example.coursework.model.location.ResultLocation

interface CharacterClickListener {
    fun onClick(tag:String, item:ResultCharacter)

}