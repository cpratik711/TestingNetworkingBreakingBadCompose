package com.pratik.breakingbadcompose.utils

import com.pratik.breakingbadcompose.R

/**
 * A sealed class to determine the network failures
 *
 */
sealed class Failure {
    abstract val key: Int

    object NetworkFailure : Failure() {
        override val key: Int
            get() = R.string.network_error
    }

    object LimitExceededFailure : Failure() {
        override val key: Int
            get() = R.string.limit_exceeded_error
    }

    object ServerFailure : Failure() {
        override val key: Int
            get() = R.string.server_error
    }

    object UnexpectedFailure : Failure() {
        override val key: Int
            get() = R.string.unexpected_error
    }
}
