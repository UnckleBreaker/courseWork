package com.example.data.mappers

object ConvertId {
    fun makeIds(episode: List<String>): String {
        var result = ""
        episode.forEach {
            it.forEach {
                if (it.isDigit()) {
                    result+=it
                }
            }
            result+=","
        }
        return result
    }
    fun makeId(episode: String): String {
        var result = ""
        episode.forEach {
            if (it.isDigit()) {
                result+=it
            }
        }
        return result
    }
}