package dev.x001.testprojectnativeandroid.model.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import dev.x001.testprojectnativeandroid.model.entity.LogRecord
import kotlinx.coroutines.flow.Flow

@Dao
interface LogDao {

    @Insert
    suspend fun insertLog(log: LogRecord)

    @Query("SELECT * FROM `log-record-table` ORDER BY id DESC")
    fun getAllLogs() : Flow<List<LogRecord>>
}