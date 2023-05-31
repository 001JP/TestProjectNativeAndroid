package dev.x001.testprojectnativeandroid.application

import android.app.Application
import dev.x001.testprojectnativeandroid.model.database.LogDatabase
import dev.x001.testprojectnativeandroid.model.database.LogRepository

class LogApplication: Application() {
    private val database by lazy {
        LogDatabase.getInstance(this)
    }

    val repository by lazy{
        LogRepository(database.logDao())
    }
}