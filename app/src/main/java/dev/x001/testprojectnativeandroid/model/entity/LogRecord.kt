package dev.x001.testprojectnativeandroid.model.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "log-record-table")
class LogRecord (
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val event: String = "",
    val timestamp: String = ""
)