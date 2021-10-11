package com.pratik.breakingbadcompose.utils

import retrofit2.HttpException
import java.net.UnknownHostException

/**
 * Error exception
 *
 */
class HttpLimitExceededException : Exception()

/**
 * Throwable function
 *
 * @return
 */
fun Throwable.toFailure(): Failure {
    return when (this) {
        is HttpException -> Failure.ServerFailure
        is HttpLimitExceededException -> Failure.LimitExceededFailure
        is UnknownHostException -> Failure.NetworkFailure
        else -> Failure.UnexpectedFailure
    }
}
