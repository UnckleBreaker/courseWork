package com.example.coursework.model

import com.example.coursework.listeners.LocationClickListener
import com.example.coursework.model.character.ResultCharacter
import java.io.Serializable

data class DetailsCharacterFragmentArguments(val model: ResultCharacter, val listener: LocationClickListener):Serializable
