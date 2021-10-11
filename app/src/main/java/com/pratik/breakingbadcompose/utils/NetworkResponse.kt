package com.pratik.breakingbadcompose.utils

sealed class NetworkResponse<out T> {
    data class Success<out T>(val value: T): NetworkResponse<T>()
    data class HttpError(val code: Int? = null,val responseBody:String): NetworkResponse<Nothing>()
    object Error: NetworkResponse<Nothing>()
    object Empty: NetworkResponse<Nothing>()
}