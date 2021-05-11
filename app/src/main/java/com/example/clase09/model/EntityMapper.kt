package com.example.clase09.model

interface EntityMapper<T,V> {

    fun mapFromCached(type: T): V

    fun mapToCached(type: V): T
}