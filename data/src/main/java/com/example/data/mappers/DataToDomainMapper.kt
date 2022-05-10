package com.example.data.mappers
interface DataToDomainMapper<in T,out E> {

    fun map(from : T): E
}