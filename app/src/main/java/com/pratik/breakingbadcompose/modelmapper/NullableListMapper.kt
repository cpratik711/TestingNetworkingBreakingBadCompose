package com.pratik.breakingbadcompose.modelmapper

interface NullableListMapperInterface<I, O> : Mapper<List<I>?, List<O>?>
/**
 * Produces null if the input is null or empty
 */
class NullableListMapper<I, O>(private val mapper: Mapper<I, O>) :
    NullableListMapperInterface<I, O> {

    override fun map(input: List<I>?): List<O>? {
        return if (input == null || input.isEmpty()) null else input.map { mapper.map(it) }
    }
}