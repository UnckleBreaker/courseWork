package com.example.coursework.listeners.dialog

import java.io.Serializable

interface DialogLocationsListener : Serializable {
    fun selected(name:String,type:String,demension:String)
}