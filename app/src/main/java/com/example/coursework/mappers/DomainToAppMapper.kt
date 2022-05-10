package com.example.app.mappers

interface DomainToAppMapper<in T,out E> {

    fun map(from : T): E
}