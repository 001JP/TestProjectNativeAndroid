package dev.x001.testprojectnativeandroid.view.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import dev.x001.testprojectnativeandroid.application.LogApplication
import dev.x001.testprojectnativeandroid.databinding.ActivityMainBinding
import dev.x001.testprojectnativeandroid.model.entity.LogRecord
import dev.x001.testprojectnativeandroid.utils.Constants
import dev.x001.testprojectnativeandroid.viewmodel.LogViewModel
import dev.x001.testprojectnativeandroid.viewmodel.LogViewModelFactory

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding

    private val mLogViewModel: LogViewModel by viewModels {
        LogViewModelFactory((this.application as LogApplication).repository)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button1.setOnClickListener {
            mLogViewModel.insertLogRecord(
                LogRecord(event = "Button 1 pressed", timestamp = Constants.getTimeStamp())
            )
        }

        binding.button2.setOnClickListener {
            mLogViewModel.insertLogRecord(
                LogRecord(event = "Button 2 pressed", timestamp = Constants.getTimeStamp())
            )
        }

        binding.button3.setOnClickListener {
            mLogViewModel.insertLogRecord(
                LogRecord(event = "Button 3 pressed", timestamp = Constants.getTimeStamp())
            )
        }

        binding.button4.setOnClickListener {
            mLogViewModel.insertLogRecord(
                LogRecord(event = "Button 4 pressed", timestamp = Constants.getTimeStamp())
            )
        }

        binding.showLogsTextView.setOnClickListener {
            startActivity(Intent(this, LogsActivity::class.java))
        }

    }
}