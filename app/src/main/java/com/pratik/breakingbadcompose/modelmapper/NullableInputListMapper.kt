package com.pratik.breakingbadcompose.modelmapper

interface NullableInputListMapperInterface<I, O> : Mapper<List<I>?, List<O>>

/**
 * Produces empty if the input is null
 */
class NullableInputListMapper<I, O>(private val mapper: Mapper<I, O>) :
    NullableInputListMapperInterface<I, O> {

    override fun map(input: List<I>?): List<O> {
        return input?.map { mapper.map(it) }.orEmpty()
    }

}