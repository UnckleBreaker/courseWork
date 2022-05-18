package com.example.coursework.listeners.dialog

import java.io.Serializable

interface DialogEpisodesListener :Serializable {
    fun selected(name:String,episode:String)
}