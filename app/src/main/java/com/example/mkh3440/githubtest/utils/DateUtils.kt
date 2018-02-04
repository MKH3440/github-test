package com.example.mkh3440.githubtest.utils

import java.text.SimpleDateFormat
import java.util.*

/**
 * Created by kahem on 04/02/2018.
 */
class DateUtils {
    companion object {
        val SERVER_FORMAT = "yyyy-MM-dd'T'HH:mm:ss'Z'"
        val COMMON_FORMAT = "dd/MM/yyyy"
        fun toCommonDate(serverDate: String): String {
            val serverDateFormat = SimpleDateFormat(SERVER_FORMAT, Locale.FRANCE)
                    .apply { timeZone = TimeZone.getTimeZone("CET") }
            val date = serverDateFormat.parse(serverDate)

            return SimpleDateFormat(COMMON_FORMAT, Locale.FRANCE).format(date)
        }
    }
}