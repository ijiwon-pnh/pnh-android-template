package com.pnhglobal.data.utils

import okhttp3.MediaType.Companion.toMediaType
import okhttp3.RequestBody
import okhttp3.RequestBody.Companion.toRequestBody

fun setValue(value: String): RequestBody =
    value.toRequestBody("application/x-www-form-urlencoded; charset=utf-8".toMediaType())

fun setValue(value: Long): RequestBody =
    value.toString().toRequestBody("application/x-www-form-urlencoded; charset=utf-8".toMediaType())

fun setValue(value: Int): RequestBody =
    value.toString().toRequestBody("application/x-www-form-urlencoded; charset=utf-8".toMediaType())