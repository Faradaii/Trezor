package com.faradaii.trezor.core.common.utils

import java.text.SimpleDateFormat
import java.util.Locale
import java.util.TimeZone

object DateFormatter {
    fun formatIsoDate(isoDate: String): String {
        return try {
            val isoFormat =
                SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.getDefault()).apply {
                    timeZone = TimeZone.getTimeZone("UTC")
                }
            val date = isoFormat.parse(isoDate) ?: return "Invalid date"

            val humanFormat = SimpleDateFormat("EEEE, dd MMMM yyyy HH:mm", Locale.getDefault())
            humanFormat.format(date)
        } catch (e: Exception) {
            "Invalid date format"
        }
    }
}