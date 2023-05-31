package dev.x001.testprojectnativeandroid.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import dev.x001.testprojectnativeandroid.model.database.LogRepository
import dev.x001.testprojectnativeandroid.model.entity.LogRecord
import kotlinx.coroutines.launch

class LogViewModel(private val repository: LogRepository): ViewModel() {

    fun insertLogRecord(log: LogRecord) = viewModelScope.launch {
        repository.insertLog(log)
    }

    val allLogRecordList: LiveData<List<LogRecord>> = repository.allLogs.asLiveData()
}

class LogViewModelFactory(private val repository: LogRepository): ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(LogViewModel::class.java)){
            @Suppress("UNCHECKED_CAST")
            return LogViewModel(repository) as T
        }
        throw IllegalAccessException("Unknown ViewModel Class")
    }
}