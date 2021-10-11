package com.pratik.breakingbadcompose.utils

sealed class Status<out DTO : Any> {

    data class OnSuccess<out DTO : Any>(val response: DTO) : Status<DTO>()

    data class OnFailed(val throwable: Throwable) : Status<Nothing>()

    object Loading : Status<Nothing>()
}