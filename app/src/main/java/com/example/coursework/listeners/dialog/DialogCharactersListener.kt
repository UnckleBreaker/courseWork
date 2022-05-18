package com.example.coursework.listeners.dialog

import java.io.Serializable

interface DialogCharactersListener :Serializable{
    fun selected(status: String, spicies: String, gender: String, type: String)
}