package dev.x001.testprojectnativeandroid.utils

import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

object Constants {

    fun getTimeStamp(): String{
        val dateFormat = SimpleDateFormat("dd/MM/yyyy hh:mm a", Locale.getDefault())
        val currentTime = Calendar.getInstance().time
        return dateFormat.format(currentTime)
    }

}