package dev.x001.testprojectnativeandroid.model.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import dev.x001.testprojectnativeandroid.model.entity.LogRecord

@Database(entities = [LogRecord::class], version = 1)
abstract class LogDatabase: RoomDatabase() {

    abstract fun logDao(): LogDao

    companion object{

        @Volatile
        private var INSTANCE: LogDatabase? = null

        fun getInstance(context: Context): LogDatabase{
            synchronized(this){
                var instance = INSTANCE

                if (instance == null){
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        LogDatabase::class.java,
                        "log_database"
                    ).fallbackToDestructiveMigration()
                        .build()

                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}