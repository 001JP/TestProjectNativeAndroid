package dev.x001.testprojectnativeandroid.model.database

import androidx.annotation.WorkerThread
import dev.x001.testprojectnativeandroid.model.entity.LogRecord
import kotlinx.coroutines.flow.Flow

class LogRepository(private val logDao: LogDao) {

    @WorkerThread
    suspend fun insertLog(log: LogRecord){
        logDao.insertLog(log)
    }

    val allLogs: Flow<List<LogRecord>> = logDao.getAllLogs()

}