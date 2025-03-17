package com.energopro.network.rest.ext

import com.energopro.network.rest.result.NetworkError

/**
 * Checks whether given [Throwable] is [NetworkError.ConnectionError]
 */
fun Throwable.isConnectionError(): Boolean = this is NetworkError.ConnectionError
