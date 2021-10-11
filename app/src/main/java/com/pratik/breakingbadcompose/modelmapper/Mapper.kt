package com.pratik.breakingbadcompose.modelmapper

interface Mapper<I, O> {
    fun map(input: I) : O
}