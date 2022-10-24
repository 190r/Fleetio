package com.fleetio.common

/**
 * Wraps possible API response scenarios.
 * By passing a wrapper class to the call site, the presentation layer can handle
 * results depending on the response type.
 */
sealed class ApiResponse<S>(val data: S? = null, val message: String? = null) {
    /**
     * API result on success
     */
    class Success<S>(data: S) : ApiResponse<S>(data)

    /**
     * Recoverable error
     */
    class Error<E>(message: String?, error: E? = null): ApiResponse<E>(error, message)

    /**
     * Unrecoverable error
     */
    class Exception<E>(message: String?, error: E? = null): ApiResponse<E>(error, message)

    /**
     * Data loading in progress
     */
    class Loading<S>(data: S? = null): ApiResponse<S>(data)
}
