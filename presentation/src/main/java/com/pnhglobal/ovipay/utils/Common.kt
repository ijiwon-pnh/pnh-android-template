package com.pnhglobal.ovipay.utils

import android.content.Context
import com.pnhglobal.ovipay.R
import okhttp3.Cache
import okhttp3.HttpUrl.Companion.toHttpUrlOrNull
import java.text.SimpleDateFormat
import java.util.Locale

// 시스템의 Navigation Bar 높이를 가져오는 함수
fun getNavigationBarHeight(context: Context): Int {
    val resources = context.resources
    val resourceId = resources.getIdentifier("navigation_bar_height", "dimen", "android")
    if (resourceId > 0) {
        return resources.getDimensionPixelSize(resourceId)
    }
    return 0
}

fun Cache.clearMalformedUrls(): Cache {
    // corrupt 된 캐시 삭제하기
    val urlIterator = urls()
    while (urlIterator.hasNext()) {
        if (urlIterator.next().toHttpUrlOrNull() == null) {
            urlIterator.remove()
        }
    }

    return this
}

/** 몇분전, 방금 전,  */
object TimeMaximum {
    const val SEC = 60
    const val MIN = 60
    const val HOUR = 24
    const val DAY = 30
    const val MONTH = 12
}

fun formatTimeString(context: Context, regTime: Long?): String {
    if (regTime == null) {
        return context.getString(R.string.str_unknown)
    }

    val curTime = System.currentTimeMillis()
    var diffTime = (curTime - regTime) / 1000

    return when {
        diffTime < TimeMaximum.SEC -> {
            context.getString(
                R.string.time1
            )
        }

        (diffTime / TimeMaximum.SEC.toLong()) < TimeMaximum.MIN -> {
            (diffTime / TimeMaximum.SEC.toLong()).toString() + context.getString(
                R.string.time2
            )
        }

        (diffTime / TimeMaximum.MIN.toLong() / TimeMaximum.SEC.toLong()) < TimeMaximum.HOUR -> {
            (diffTime / TimeMaximum.MIN.toLong() / TimeMaximum.SEC.toLong()).toString() + context.getString(
                R.string.time3
            )
        }

        (diffTime / TimeMaximum.HOUR.toLong() / TimeMaximum.MIN.toLong() / TimeMaximum.SEC.toLong()) < TimeMaximum.DAY -> {
            (diffTime / TimeMaximum.HOUR.toLong() / TimeMaximum.MIN.toLong() / TimeMaximum.SEC.toLong()).toString() + context.getString(
                R.string.time4
            )
        }

        (diffTime / TimeMaximum.DAY.toLong() / TimeMaximum.HOUR.toLong() / TimeMaximum.MIN.toLong() / TimeMaximum.SEC.toLong()) < TimeMaximum.MONTH -> {
            (diffTime / TimeMaximum.DAY.toLong() / TimeMaximum.HOUR.toLong() / TimeMaximum.MIN.toLong() / TimeMaximum.SEC.toLong()).toString() + context.getString(
                R.string.time5
            )
        }

        else -> {
            (diffTime / TimeMaximum.MONTH.toLong() / TimeMaximum.DAY.toLong() / TimeMaximum.HOUR.toLong() / TimeMaximum.MIN.toLong() / TimeMaximum.SEC.toLong()).toString() + context.getString(
                R.string.time6
            )
        }
    }
}

fun formatTimeString(context: Context, regTimeString: String?): String {
    regTimeString?.let {
        val sdf = SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.KOREA)
        val regTimeDate = sdf.parse(regTimeString)
        val regTime = regTimeDate.time

        return formatTimeString(context, regTime)
    }

    return ""
}