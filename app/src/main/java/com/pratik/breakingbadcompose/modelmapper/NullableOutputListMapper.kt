package com.pratik.breakingbadcompose.modelmapper

interface NullableOutputListMapperInterface<I, O> : Mapper<List<I>, List<O>?>

/**
 * Produces null if the input is empty
 */
class NullableOutputListMapper<I, O>(private val mapper: Mapper<I, O>) :
    NullableOutputListMapperInterface<I, O> {

    override fun map(input: List<I>): List<O>? {
        return if (input.isEmpty()) null else input.map { mapper.map(it) }
    }
}